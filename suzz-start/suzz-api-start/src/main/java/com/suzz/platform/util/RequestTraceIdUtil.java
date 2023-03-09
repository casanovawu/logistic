package com.suzz.platform.util;

import java.util.UUID;

public class RequestTraceIdUtil {

    private final static String REPLACED_CHAR = "-";

    private final static String REPLACER = "0";

    public static String create() {
        return UUID.randomUUID().toString().replace(REPLACED_CHAR, REPLACER);
    }

}
