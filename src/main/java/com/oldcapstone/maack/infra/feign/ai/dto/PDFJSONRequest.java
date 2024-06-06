package com.oldcapstone.maack.infra.feign.ai.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PDFJSONRequest {

    private String url;

    public PDFJSONRequest(String url) {
        this.url = url;
    }
}
