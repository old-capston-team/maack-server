package com.oldcapstone.maack.sheetmusic.implement;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Component;

import javax.sound.midi.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MidiToMusicXMLConverter {

    public byte[] convertMidiToMusicXML(byte[] midiBytes) throws IOException, InvalidMidiDataException, JAXBException {
        // MIDI 파일을 Sequence로 변환
        Sequence sequence;
        try (ByteArrayInputStream bis = new ByteArrayInputStream(midiBytes)) {
            sequence = MidiSystem.getSequence(bis);
        }

        // MusicXML의 루트 요소를 생성
        ScorePartwise scorePartwise = new ScorePartwise();
        ScorePartwise.Part part = new ScorePartwise.Part();
        scorePartwise.getParts().add(part);

        // 각 트랙을 처리
        Track[] tracks = sequence.getTracks();
        for (Track track : tracks) {
            ScorePartwise.Measure measure = new ScorePartwise.Measure();
            part.getMeasures().add(measure);
            for (int i = 0; i < track.size(); i++) {
                MidiEvent event = track.get(i);
                MidiMessage message = event.getMessage();

                if (message instanceof ShortMessage) {
                    ShortMessage sm = (ShortMessage) message;
                    int command = sm.getCommand();
                    if (command == ShortMessage.NOTE_ON || command == ShortMessage.NOTE_OFF) {
                        // 노트를 MusicXML 형식으로 변환
                        ScorePartwise.Note note = new ScorePartwise.Note();
                        note.setPitch(sm.getData1());
                        note.setDuration(sm.getData2());
                        measure.getNotes().add(note);
                    }
                }
            }
        }

        // MusicXML을 XML 형식으로 변환
        JAXBContext jaxbContext = JAXBContext.newInstance(ScorePartwise.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            marshaller.marshal(scorePartwise, baos);
            return baos.toByteArray();
        }
    }
}
