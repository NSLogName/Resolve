package com.xcty.resolve.dao.entity;

public class Timeout {
    /**
     * <pre>
     * 
     * 表字段 : t_timeout.id
     * </pre>
     * 
     */
    private Integer id;

    /**
     * <pre>
     * 
     * 表字段 : t_timeout.url
     * </pre>
     * 
     */
    private String url;

    /**
     * <pre>
     * 
     * 表字段 : t_timeout.passtime
     * </pre>
     * 
     */
    private Integer passtime;

    /**
     * <pre>
     * 
     * 表字段 : t_timeout.date
     * </pre>
     * 
     */
    private String date;

    /**
     * <pre>
     * 
     * 表字段 : t_timeout.time
     * </pre>
     * 
     */
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getPasstime() {
        return passtime;
    }

    public void setPasstime(Integer passtime) {
        this.passtime = passtime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    @Override
    public String toString() {
        return "Timeout{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", passtime=" + passtime +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}