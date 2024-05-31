package com.judaocva.books.Login.Dto;

public class CreateAppKeyResponse {
    String status, appkey, id, createdVNB, req;

    public CreateAppKeyResponse() {
    }

    public CreateAppKeyResponse(String status, String appkey, String id, String createdVNB, String req) {
        this.status = status;
        this.appkey = appkey;
        this.id = id;
        this.createdVNB = createdVNB;
        this.req = req;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedVNB() {
        return createdVNB;
    }

    public void setCreatedVNB(String createdVNB) {
        this.createdVNB = createdVNB;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }

    public String toString() {
        return "CreateAppKeyResponse{" +
                "status='" + status + '\'' +
                ", appkey='" + appkey + '\'' +
                ", id='" + id + '\'' +
                ", createdVNB='" + createdVNB + '\'' +
                ", req='" + req + '\'' +
                '}';
    }
}
