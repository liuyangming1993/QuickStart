package com.quickstart.baselib.net;

public class BaseResponse<C> {
    private int code;
    private C content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public C getContent() {
        return content;
    }

    public void setContent(C content) {
        this.content = content;
    }
}
