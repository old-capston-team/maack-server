package com.oldcapstone.maack.infra.feign.ai.dto;

public class PDFJSONRequest {
    private byte[] PDF;

    public PDFJSONRequest(byte[] PDF) {
        this.PDF = PDF;
    }

    public byte[] getPDF() {
        return PDF;
    }

    public void setPDF(byte[] PDF) {
        this.PDF = PDF;
    }
}
