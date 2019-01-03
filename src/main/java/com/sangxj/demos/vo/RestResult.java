package com.sangxj.demos.vo;


import com.sangxj.demos.constants.ResultCode;

/**
 *
 * @param <T>
 */
public class RestResult<T> {
    private int code;
    private T data;
    private String message;

    public RestResult() {
        this.code = ResultCode.SUCCESS.ordinal();
    }

    public RestResult(T data) {
        this.code = ResultCode.SUCCESS.ordinal();
        this.data = data;
    }

    public RestResult(ResultCode code) {
        this.code = code.ordinal();
    }

    public RestResult(ResultCode code, String message) {
        this.code = code.ordinal();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RestResult{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
