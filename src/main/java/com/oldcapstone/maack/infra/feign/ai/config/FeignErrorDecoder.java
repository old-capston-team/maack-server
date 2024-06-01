package com.oldcapstone.maack.infra.feign.ai.config;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        // 에러 처리 로직 추가
        return new RuntimeException("Feign Client Error: " + response.status());
    }
}