package com.oldcapstone.maack.sheetmusic.implement;

import com.oldcapstone.maack.common.annotation.Adapter;
import com.oldcapstone.maack.infra.feign.ai.client.FastApiClient;
import com.oldcapstone.maack.infra.feign.ai.dto.MTXJSONRequest;

import com.oldcapstone.maack.infra.feign.ai.dto.MusicXMLResponse;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class MidiToMusicXMLConverter {

    private final FastApiClient fastApiClient;

    public MusicXMLResponse convertMidiToMusicXML(String midiUrl) {
        return fastApiClient.midiToXml(new MTXJSONRequest(midiUrl));
    }
}
