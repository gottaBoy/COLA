package com.zeron.sophon.extension;

/**
 * 扩展点初始化或者查找失败时，使用次异常
 * <p>
 * 扩展点初始化或者查找失败时，使用次异常
 * <p>
 */
public class ExtensionException extends RuntimeException {

    private String errCode;

    public ExtensionException(String errMessage) {
        super(errMessage);
    }

    public ExtensionException(String errCode, String errMessage) {
        super(errMessage);
        this.errCode = errCode;
    }

    public ExtensionException(String errMessage, Throwable e) {
        super(errMessage, e);
    }

    public ExtensionException(String errCode, String errMessage, Throwable e) {
        super(errMessage, e);
        this.errCode = errCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

}
