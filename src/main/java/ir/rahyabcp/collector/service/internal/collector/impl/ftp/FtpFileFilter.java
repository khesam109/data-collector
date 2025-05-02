package ir.rahyabcp.collector.service.internal.collector.impl.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class FtpFileFilter {

    private final FtpFileHandlerService ftpFileHandlerService;
    private final CollectedFileInfoService collectedFileInfoService;

    @Autowired
    FtpFileFilter(FtpFileHandlerService ftpFileHandlerService, CollectedFileInfoService collectedFileInfoService) {
        this.ftpFileHandlerService = ftpFileHandlerService;
        this.collectedFileInfoService = collectedFileInfoService;
    }

    List<String> toBeCollected(FTPClient ftpClient, String pattern) {
        List<String> existingFiles = getMatchingFiles(ftpFileHandlerService.getFileList(ftpClient), pattern);
        List<String> collectedFiles = getCollectedFiles();

        List<String> toBeCollected = new ArrayList<>(existingFiles);
        toBeCollected.removeAll(collectedFiles);

        return toBeCollected;
    }

    private List<String> getMatchingFiles(List<String> files, String pattern) {
        return files.stream()
                .filter(fileName -> fileName.matches(pattern))
                .toList();
    }

    private List<String> getCollectedFiles() {
        return this.collectedFileInfoService.fetch();
    }
}
