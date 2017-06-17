package com.api.mail.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponseWrapper {

	@JsonProperty
    String sessionId ;


    public LoginResponseWrapper() {

    }

    public LoginResponseWrapper(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
