package ir.rahyabcp.collector.common;

import java.util.EnumSet;

public enum DataNodeStatus {

    ACTIVE,
    INACTIVE
    ;

    public static DataNodeStatus fromString(String value) {
        return EnumSet.allOf(DataNodeStatus.class).stream().filter(
                dataNodeStatus -> dataNodeStatus.name().equalsIgnoreCase(value)
        ).findAny().orElseThrow(
                () -> new IllegalArgumentException("Unknown status: " + value)
        );
    }
}
