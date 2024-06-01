package com.oldcapstone.maack.sheetmusic.implement;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "score-partwise")
public class ScorePartwise {
    private List<Part> parts = new ArrayList<>();

    @XmlElement(name = "part")
    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    @XmlRootElement(name = "part")
    public static class Part {
        private String id;
        private List<Measure> measures = new ArrayList<>();

        @XmlElement(name = "measure")
        public List<Measure> getMeasures() {
            return measures;
        }

        public void setMeasures(List<Measure> measures) {
            this.measures = measures;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    @XmlRootElement(name = "measure")
    public static class Measure {
        private int number;
        private List<Note> notes = new ArrayList<>();

        @XmlElement(name = "note")
        public List<Note> getNotes() {
            return notes;
        }

        public void setNotes(List<Note> notes) {
            this.notes = notes;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }

    @XmlRootElement(name = "note")
    public static class Note {
        private int pitch;
        private int duration;

        @XmlElement(name = "pitch")
        public int getPitch() {
            return pitch;
        }

        public void setPitch(int pitch) {
            this.pitch = pitch;
        }

        @XmlElement(name = "duration")
        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }
    }
}
