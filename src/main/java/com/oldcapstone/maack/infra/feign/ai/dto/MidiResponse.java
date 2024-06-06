package com.oldcapstone.maack.infra.feign.ai.dto;

import com.amazonaws.util.Base64;

public class MidiResponse {
    private String midi;

    public byte[] getMidi() {
        return Base64.decode(midi);
    }

    public void setMidi(String midi) {
        this.midi = midi;
    }
}