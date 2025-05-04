package ir.rahyabcp.collector.service.internal.collector.impl.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

    boolean downloadFile(FTPClient ftpClient, String remoteFile , String localFile) {
        try (OutputStream outputStream = new FileOutputStream(localFile)) {
            return ftpClient.retrieveFile(remoteFile, outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
