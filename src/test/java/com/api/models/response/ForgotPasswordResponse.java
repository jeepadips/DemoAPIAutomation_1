package com.api.models.response;

public class ForgotPasswordResponse {
    private String message;

    public ForgotPasswordResponse() {
    }

    public ForgotPasswordResponse(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ForgotPasswordResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
