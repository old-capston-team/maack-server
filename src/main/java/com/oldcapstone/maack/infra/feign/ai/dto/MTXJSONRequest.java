package com.oldcapstone.maack.infra.feign.ai.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MTXJSONRequest {
    private String url;

    public MTXJSONRequest(String url) {
        this.url = url;
    }
}
