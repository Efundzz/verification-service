package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroScoreDetails {
    private String type;
    private String version;
    private String name;
    private String value;
    private ArrayList<DecentroScoringElements> scoringElements;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<DecentroScoringElements> getScoringElements() {
        return scoringElements;
    }

    public void setScoringElements(ArrayList<DecentroScoringElements> scoringElements) {
        this.scoringElements = scoringElements;
    }
}
