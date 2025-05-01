package ir.rahyabcp.collector.service.internal.collector.impl.ftp;

import ir.rahyabcp.collector.exception.LoginFailedException;
import ir.rahyabcp.collector.model.FtpDataNode;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
class FtpConnectionHandlerService {

    void connect(FTPClient ftpClient, FtpDataNode dataNode) throws IOException {
        ftpClient.connect(dataNode.getHost(), dataNode.getPort());
        if (!ftpClient.login(dataNode.getUsername(), dataNode.getPassword())) {
            throw new LoginFailedException("Failed to log in to FTP server");
        }
        this.configureFtpClient(ftpClient);
    }

    void disconnect(FTPClient ftpClient) {
        try {
            if (ftpClient.isConnected()) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (IOException ignored) {
        }
    }

    private void configureFtpClient(FTPClient ftpClient) throws IOException {
        ftpClient.enterLocalPassiveMode();
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
    }
}
