package ir.rahyabcp.collector.service.internal.collector.impl.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
class FtpFileHandlerService {

    List<String> getFileList(FTPClient ftpClient) {
        try {
            String[] files = ftpClient.listNames();
            return files != null ? List.of(files) : List.of();
        } catch (IOException ex) {
            throw new RuntimeException("Error fetching file names from FTP server", ex);
        }
    }
}
