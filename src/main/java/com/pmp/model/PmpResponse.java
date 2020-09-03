package com.pmp.model;

public class PmpResponse {
    private String code;
    private String message;
    private String activity;

    public PmpResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
