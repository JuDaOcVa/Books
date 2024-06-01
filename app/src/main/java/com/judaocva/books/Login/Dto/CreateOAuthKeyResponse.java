package com.judaocva.books.Login.Dto;

public class CreateOAuthKeyResponse {
    String status;
    String oauthkey;
    String o_u;
    String createdVNB;
    String req;
    String version;
    String error;

    public CreateOAuthKeyResponse() {
    }

    public CreateOAuthKeyResponse(String status, String oauthkey, String o_u, String createdVNB, String req, String version, String error) {
        this.status = status;
        this.oauthkey = oauthkey;
        this.o_u = o_u;
        this.createdVNB = createdVNB;
        this.req = req;
        this.version = version;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOauthkey() {
        return oauthkey;
    }

    public void setOauthkey(String oauthkey) {
        this.oauthkey = oauthkey;
    }

    public String getO_u() {
        return o_u;
    }

    public void setO_u(String o_u) {
        this.o_u = o_u;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String toString() {
        return "CreateOAuthKeyResponse{" +
                "status='" + status + '\'' +
                ", oauthkey='" + oauthkey + '\'' +
                ", o_u='" + o_u + '\'' +
                ", createdVNB='" + createdVNB + '\'' +
                ", req='" + req + '\'' +
                ", version='" + version + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
