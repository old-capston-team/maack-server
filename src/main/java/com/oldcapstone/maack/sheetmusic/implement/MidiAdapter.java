package com.oldcapstone.maack.sheetmusic.implement;

import com.oldcapstone.maack.common.annotation.Adapter;
import com.oldcapstone.maack.infra.feign.ai.client.FastApiClient;
import com.oldcapstone.maack.infra.feign.ai.dto.MidiResponse;
import com.oldcapstone.maack.infra.feign.ai.dto.PDFJSONRequest;
import com.oldcapstone.maack.sheetmusic.persistence.PDFFile;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class MidiAdapter {

    private final FastApiClient fastApiClient;

    public MidiResponse convertPdfToMidi(PDFFile pdfFile) {
        PDFJSONRequest request = new PDFJSONRequest(pdfFile.getUrl());
        return fastApiClient.pdfToMidi(request);
    }
}
