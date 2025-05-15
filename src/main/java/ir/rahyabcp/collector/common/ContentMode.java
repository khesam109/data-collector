package ir.rahyabcp.collector.common;

import java.util.EnumSet;

public enum ContentMode {

    NULL,
    CONTENT
    ;

    public static ContentMode fromString(String value) {
        return EnumSet.allOf(ContentMode.class).stream().filter(
                contentMode -> contentMode.name().equalsIgnoreCase(value)
        ).findAny().orElseThrow(
                () -> new IllegalArgumentException("Unknown content mode: " + value)
        );
    }
}
