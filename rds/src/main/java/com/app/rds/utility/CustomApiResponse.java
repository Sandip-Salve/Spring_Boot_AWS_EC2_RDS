package com.app.rds.utility;

import java.time.LocalDateTime;

public class CustomApiResponse {

    private String msg;
    private LocalDateTime timestamp;

    public CustomApiResponse(String msg){
        this.msg = msg;
        this.timestamp = LocalDateTime.now();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
