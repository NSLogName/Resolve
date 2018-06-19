package com.xcty.resolve.dao.entity;

public class ResolveLogWithBLOBs extends ResolveLog {
    /**
     * <pre>
     * 接口调用参数
     * 表字段 : t_resolve_log.invoke_param
     * </pre>
     * 
     */
    private String invokeParam;

    /**
     * <pre>
     * 接口返回参数
     * 表字段 : t_resolve_log.invoke_result
     * </pre>
     * 
     */
    private String invokeResult;

    public String getInvokeParam() {
        return invokeParam;
    }

    public void setInvokeParam(String invokeParam) {
        this.invokeParam = invokeParam == null ? null : invokeParam.trim();
    }

    public String getInvokeResult() {
        return invokeResult;
    }

    public void setInvokeResult(String invokeResult) {
        this.invokeResult = invokeResult == null ? null : invokeResult.trim();
    }
}