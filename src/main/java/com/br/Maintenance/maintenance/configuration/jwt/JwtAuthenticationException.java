package com.br.Maintenance.maintenance.configuration.jwt;


import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

import javax.management.ConstructorParameters;

public class JwtAuthenticationException extends AuthenticationException {

    private HttpStatus httpStatus;

    public JwtAuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }

    public JwtAuthenticationException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

}