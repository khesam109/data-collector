package ir.rahyabcp.collector.model;

import ir.rahyabcp.collector.common.ConnectionProtocol;
import ir.rahyabcp.collector.common.ContentMode;
import ir.rahyabcp.collector.common.DataNodeStatus;

public abstract class DataNode {

    private final int id;
    private final String name;
    private final DataNodeStatus status;
    private final ContentMode contentMode;
    private final ConnectionProtocol connectionProtocol;
    private final String description;
    private final DataFormat dataFormat;
    private final RetryPolicy retryPolicy;

    protected DataNode(
            int id, String name, DataNodeStatus status, ContentMode contentMode, ConnectionProtocol connectionProtocol,
            String description, DataFormat dataFormat, RetryPolicy retryPolicy
    ) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.contentMode = contentMode;
        this.connectionProtocol = connectionProtocol;
        this.description = description;
        this.dataFormat = dataFormat;
        this.retryPolicy = retryPolicy;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DataNodeStatus getStatus() {
        return status;
    }

    public ContentMode getContentMode() {
        return contentMode;
    }

    public ConnectionProtocol getConnectionProtocol() {
        return connectionProtocol;
    }

    public String getDescription() {
        return description;
    }

    public DataFormat getDataFormat() {
        return dataFormat;
    }

    public RetryPolicy getRetryPolicy() {
        return retryPolicy;
    }

    //    protected DataNode(
//            ConnectionProtocol connectionProtocol,
//            RetryPolicy retryPolicy
//    ) {
//        this.connectionProtocol = connectionProtocol;
//        this.retryPolicy = retryPolicy;
//    }
//
//    public ConnectionProtocol getConnectionProtocol() {
//        return connectionProtocol;
//    }
//
//    public RetryPolicy getRetryPolicy() {
//        return retryPolicy;
//    }
}
