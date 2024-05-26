package com.oldcapstone.maack.sheetmusic.implement;

import com.oldcapstone.maack.common.annotation.Adapter;
import com.oldcapstone.maack.infra.feign.ai.client.FastApiClient;
import com.oldcapstone.maack.infra.feign.ai.dto.MidiResponse;
import com.oldcapstone.maack.infra.feign.ai.dto.PDFJSONRequest;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class MidiAdapter {

    private final FastApiClient fastApiClient;

    public MidiResponse convertPdfToMidi(byte[] pdfBytes) {
        PDFJSONRequest request = new PDFJSONRequest(pdfBytes);
        return fastApiClient.pdfToMidi(request);
    }
}
