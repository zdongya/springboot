package com.dongya.study.springcloud.domain;

/**
 * Created by Andy on 2017/8/31.
 */
public class BaseResponse {
    public int code = 1;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BaseResponse(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
