package com.oldcapstone.maack.infra.feign.ai.dto;

import com.amazonaws.util.Base64;

public class MusicXMLResponse {

    private String musicxml;

    public byte[] getMusicxml() {
        return Base64.decode(musicxml);
    }

    public void setMusicxml(String musicxml) {
        this.musicxml = musicxml;
    }
}
