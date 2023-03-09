package com.suzz.platform.dto;

import java.io.Serializable;

/**
 * @author subo
 * @date 2022/4/23 8:53
 **/
public class EmptyData implements Serializable {

    private static final long serialVersionUID = 7349652966715123799L;

    private static EmptyData instance = new EmptyData();

    public String toString() {
        return "";
    }

    public static EmptyData getInstance() {
        return instance;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else {
            return o instanceof EmptyData;
        }
    }

    private EmptyData() {
    }
}
