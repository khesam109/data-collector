package ir.rahyabcp.collector.dataaccess.remote.datanodelist.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FtpPropertiesDto extends ExtendedPropertiesDto {

    @JsonProperty("ftp_source_ipv4")
    private String ftpSourceIpv4;

    @JsonProperty("ftp_source_path")
    private String ftpSourcePath;

    @JsonProperty("ftp_source_mask")
    private String ftpSourceMask;

    @JsonProperty("ftp_destination_path")
    private String ftpDestinationPath;

    @JsonProperty("ftp_username")
    private String ftpUsername;

    @JsonProperty("ftp_password")
    private String ftpPassword;

    @JsonProperty("ftp_segment_size")
    private Integer ftpSegmentSize;

    @JsonProperty("ftp_polling_interval")
    private Integer ftpPollingInterval;

    public String getFtpSourceIpv4() {
        return ftpSourceIpv4;
    }

    public void setFtpSourceIpv4(String ftpSourceIpv4) {
        this.ftpSourceIpv4 = ftpSourceIpv4;
    }

    public String getFtpSourcePath() {
        return ftpSourcePath;
    }

    public void setFtpSourcePath(String ftpSourcePath) {
        this.ftpSourcePath = ftpSourcePath;
    }

    public String getFtpSourceMask() {
        return ftpSourceMask;
    }

    public void setFtpSourceMask(String ftpSourceMask) {
        this.ftpSourceMask = ftpSourceMask;
    }

    public String getFtpDestinationPath() {
        return ftpDestinationPath;
    }

    public void setFtpDestinationPath(String ftpDestinationPath) {
        this.ftpDestinationPath = ftpDestinationPath;
    }

    public String getFtpUsername() {
        return ftpUsername;
    }

    public void setFtpUsername(String ftpUsername) {
        this.ftpUsername = ftpUsername;
    }

    public String getFtpPassword() {
        return ftpPassword;
    }

    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }

    public Integer getFtpSegmentSize() {
        return ftpSegmentSize;
    }

    public void setFtpSegmentSize(Integer ftpSegmentSize) {
        this.ftpSegmentSize = ftpSegmentSize;
    }

    public Integer getFtpPollingInterval() {
        return ftpPollingInterval;
    }

    public void setFtpPollingInterval(Integer ftpPollingInterval) {
        this.ftpPollingInterval = ftpPollingInterval;
    }
}
