package com.oldcapstone.maack.infra.feign.ai.client;

import com.oldcapstone.maack.infra.feign.ai.config.FeignClientConfig;
import com.oldcapstone.maack.infra.feign.ai.dto.MidiResponse;
import com.oldcapstone.maack.infra.feign.ai.dto.PDFJSONRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "pdfToMidiClient", url = "http://222.98.35.241", configuration = FeignClientConfig.class)
public interface FastApiClient {
    @PostMapping("/pdf_to_midi")
    MidiResponse pdfToMidi(@RequestBody PDFJSONRequest pdfjsonRequest);
}
