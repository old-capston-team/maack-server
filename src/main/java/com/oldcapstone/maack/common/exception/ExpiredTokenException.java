package com.oldcapstone.maack.common.exception;

public class ExpiredTokenException extends BaseCodeException {
    public static final BaseCodeException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(AuthErrorCode.TOKEN_EXPIRED);
    }
}
