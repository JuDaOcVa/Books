package com.judaocva.books.Login.Dto;

public class CreateSessKeyResponse {
    String status;
    String sesskey;
    String createdVNB;
    String req;
    String error;

    public CreateSessKeyResponse() {
    }

    public CreateSessKeyResponse(String status, String sesskey, String createdVNB, String req, String error) {
        this.status = status;
        this.sesskey = sesskey;
        this.createdVNB = createdVNB;
        this.req = req;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSesskey() {
        return sesskey;
    }

    public void setSesskey(String sesskey) {
        this.sesskey = sesskey;
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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String toString() {
        return "CreateSessKeyResponse{" +
                "status='" + status + '\'' +
                ", sesskey='" + sesskey + '\'' +
                ", createdVNB='" + createdVNB + '\'' +
                ", req='" + req + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
