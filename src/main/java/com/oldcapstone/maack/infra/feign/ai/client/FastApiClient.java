package com.oldcapstone.maack.infra.feign.ai.client;

import com.oldcapstone.maack.infra.feign.ai.config.FeignClientConfig;
import com.oldcapstone.maack.infra.feign.ai.dto.MidiResponse;
import com.oldcapstone.maack.infra.feign.ai.dto.PDFJSONRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pdfToMidiClient", url = "http://localhost:30000", configuration = FeignClientConfig.class)
public interface FastApiClient {
    @PostMapping("/pdf_to_midi")
    MidiResponse pdfToMidi(@RequestBody PDFJSONRequest pdfjsonRequest);
}
