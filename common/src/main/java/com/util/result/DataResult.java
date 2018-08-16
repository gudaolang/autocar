package com.util.result;


import com.util.ConstantParams;
import org.apache.commons.httpclient.HttpStatus;

/**
 * @author lee
 * @Date:28/02/2018
 */

public class DataResult<T> {

    private String msg;

    private int code;

    private T data;
    
    public DataResult() {
    }

    public DataResult(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public  DataResult(int code, T data, String msg) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public DataResult(T data) {
        this.code = HttpStatus.SC_OK;
        this.data = data;
        this.msg = ConstantParams.MSG_OK;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    @Override
    public String toString() {
        return "{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
