package com.xcty.resolve.dao.entity;

public class TimeoutWithBlobs extends Timeout {
    /**
     * <pre>
     * 
     * 表字段 : t_timeout.param
     * </pre>
     * 
     */
    private String param;

    /**
     * <pre>
     * 
     * 表字段 : t_timeout.result
     * </pre>
     * 
     */
    private String result;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    @Override
    public String toString() {
        return "TimeoutWithBlobs{" +
                "param='" + param + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}