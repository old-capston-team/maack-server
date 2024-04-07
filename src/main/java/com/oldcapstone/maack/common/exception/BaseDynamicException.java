package com.oldcapstone.maack.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseDynamicException extends RuntimeException {
    private final int status;
    private final String code;
    private final String reason;
}
