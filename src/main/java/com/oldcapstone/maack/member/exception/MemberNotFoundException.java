package com.oldcapstone.maack.member.exception;

import com.oldcapstone.maack.common.exception.BaseCodeException;

public class MemberNotFoundException extends BaseCodeException {
    public static BaseCodeException EXCEPTION = new MemberNotFoundException();

    private MemberNotFoundException() {
        super(MemberErrorCode.MEMBER_NOT_FOUND);
    }
}
