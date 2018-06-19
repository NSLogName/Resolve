package com.xcty.resolve.dao.entity;

public class ResolveLog {
    /**
     * <pre>
     * 
     * 表字段 : t_resolve_log.id
     * </pre>
     * 
     */
    private Integer id;

    /**
     * <pre>
     * 接口地址
     * 表字段 : t_resolve_log.invoke_url
     * </pre>
     * 
     */
    private String invokeUrl;

    /**
     * <pre>
     * 接口耗时
     * 表字段 : t_resolve_log.invoke_passtime
     * </pre>
     * 
     */
    private Integer invokePasstime;

    /**
     * <pre>
     * 接口调用时间
     * 表字段 : t_resolve_log.invoke_time
     * </pre>
     * 
     */
    private String invokeTime;

    /**
     * <pre>
     * 备注
     * 表字段 : t_resolve_log.memo
     * </pre>
     * 
     */
    private String memo;

    /**
     * <pre>
     * 创建时间
     * 表字段 : t_resolve_log.create_time
     * </pre>
     * 
     */
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvokeUrl() {
        return invokeUrl;
    }

    public void setInvokeUrl(String invokeUrl) {
        this.invokeUrl = invokeUrl == null ? null : invokeUrl.trim();
    }

    public Integer getInvokePasstime() {
        return invokePasstime;
    }

    public void setInvokePasstime(Integer invokePasstime) {
        this.invokePasstime = invokePasstime;
    }

    public String getInvokeTime() {
        return invokeTime;
    }

    public void setInvokeTime(String invokeTime) {
        this.invokeTime = invokeTime == null ? null : invokeTime.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}