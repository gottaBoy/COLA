package com.zeron.sophon.catchlog;

public interface ResponseHandlerI {
    public Object handle(Class returnType, String errCode, String errMsg);
}
