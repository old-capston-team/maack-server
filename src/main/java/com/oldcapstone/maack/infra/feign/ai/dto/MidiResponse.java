package com.oldcapstone.maack.infra.feign.ai.dto;

import java.util.List;

public class MidiResponse {
    private List<byte[]> midi;

    public List<byte[]> getMidi() {
        return midi;
    }

    public void setMidi(List<byte[]> midi) {
        this.midi = midi;
    }
}