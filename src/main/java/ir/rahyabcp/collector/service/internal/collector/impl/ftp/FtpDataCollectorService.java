package ir.rahyabcp.collector.service.internal.collector.impl.ftp;

import ir.rahyabcp.collector.common.ConnectionProtocol;
import ir.rahyabcp.collector.model.FtpDataNode;
import ir.rahyabcp.collector.service.internal.collector.DataCollectionService;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
class FtpDataCollectorService implements DataCollectionService<FtpDataNode> {

    private final FtpConnectionHandlerService ftpConnectionHandlerService;
    private final FtpFileFilter ftpFileFilter;

    @Autowired
    FtpDataCollectorService(
            FtpConnectionHandlerService ftpConnectionHandlerService,
            FtpFileFilter ftpFileFilter
    ) {
        this.ftpConnectionHandlerService = ftpConnectionHandlerService;
        this.ftpFileFilter = ftpFileFilter;
    }

    @Override
    public void collectAndProcess(FtpDataNode dataNode) {
        FTPClient ftpClient = new FTPClient();
        try {
            this.ftpConnectionHandlerService.connect(ftpClient, dataNode);
            this.ftpFileFilter.getMatchingFiles(ftpClient, ".*\\.txt$").forEach(System.out::println);
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
