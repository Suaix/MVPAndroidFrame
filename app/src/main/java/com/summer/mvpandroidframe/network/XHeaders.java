package com.summer.mvpandroidframe.network;

import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Headers;

/**
 * Created by xiahailiang on 2018/2/12.
 */

public class XHeaders {

    Headers mHeaders;

    public XHeaders(Headers headers) {
        this.mHeaders = headers;
    }

    public String get(String name) {
        if (null == mHeaders) {
            return null;
        }
        return mHeaders.get(name);
    }

    public int size() {
        if (null == mHeaders)
            return 0;
        return mHeaders.size();
    }

    public Set<String> names() {
        if (null == mHeaders)
            return null;
        return mHeaders.names();
    }

    public List<String> values(String name) {
        if (null == mHeaders)
            return null;
        return mHeaders.values(name);
    }

    @Override
    public String toString() {
        if (null == mHeaders)
            return "";
        return mHeaders.toString();
    }

    public Map<String, List<String>> toMultimap() {
        if (null == mHeaders)
            return null;
        return mHeaders.toMultimap();
    }
}
