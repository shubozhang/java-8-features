package com.java8.features.loganalysis.model;

import java.time.LocalDate;

/**
 * Created by shubo.zhang on 7/1/2016.
 */
public class ApacheLog {
    private String host;
    private LocalDate date;
    private String path;
    private Integer status;
    private Integer size;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ApacheLog{" +
                "host='" + host + '\'' +
                ", date=" + date +
                ", path='" + path + '\'' +
                ", status=" + status +
                ", size=" + size +
                '}';
    }
}
