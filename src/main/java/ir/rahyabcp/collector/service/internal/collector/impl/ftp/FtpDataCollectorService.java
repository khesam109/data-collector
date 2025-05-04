package ir.rahyabcp.collector.service.internal.collector.impl.ftp;

import ir.rahyabcp.collector.common.ConnectionProtocol;
import ir.rahyabcp.collector.model.FtpDataNode;
import ir.rahyabcp.collector.service.internal.collector.DataCollectionService;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
class FtpDataCollectorService implements DataCollectionService<FtpDataNode> {

    private final FtpConnectionHandlerService ftpConnectionHandlerService;
    private final FtpFileFilter ftpFileFilter;
    private final FtpFileHandlerService ftpFileHandlerService;
    private final DigestCalculatorService digestCalculatorService;

    @Autowired
    FtpDataCollectorService(
            FtpConnectionHandlerService ftpConnectionHandlerService,
            FtpFileFilter ftpFileFilter,
            FtpFileHandlerService ftpFileHandlerService,
            DigestCalculatorService digestCalculatorService
    ) {
        this.ftpConnectionHandlerService = ftpConnectionHandlerService;
        this.ftpFileFilter = ftpFileFilter;
        this.ftpFileHandlerService = ftpFileHandlerService;
        this.digestCalculatorService = digestCalculatorService;
    }

    @Override
    public void collectAndProcess(FtpDataNode dataNode) {
        FTPClient ftpClient = new FTPClient();
        try {
            this.ftpConnectionHandlerService.connect(ftpClient, dataNode);
            List<String> files = this.ftpFileFilter.toBeCollected(
                    ftpClient, dataNode.getFilePattern()
            );

            for (String fileName : files) {
                boolean downloaded = this.ftpFileHandlerService.downloadFile(
                        ftpClient, dataNode.getRemotePath() + fileName, dataNode.getLocalPath() + fileName
                );

                if (downloaded) {
                    String digest = this.digestCalculatorService.calculate(dataNode.getLocalPath() + fileName);
                    System.out.println(digest);
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            this.ftpConnectionHandlerService.disconnect(ftpClient);
        }
    }

    @Override
    public ConnectionProtocol getSupportedProtocol() {
        return ConnectionProtocol.FTP;
    }
}
