package ir.rahyabcp.collector.service.internal.collector.impl.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class FtpFileFilter {

    private final FtpFileHandlerService ftpFileHandlerService;

    @Autowired
    FtpFileFilter(FtpFileHandlerService ftpFileHandlerService) {
        this.ftpFileHandlerService = ftpFileHandlerService;
    }

    List<String> getMatchingFiles(FTPClient ftpClient, String pattern) {
        List<String> files = ftpFileHandlerService.getFileList(ftpClient);

        return files.stream()
                .filter(fileName -> fileName.matches(pattern))
                .toList();
    }
}
