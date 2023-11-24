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
}
