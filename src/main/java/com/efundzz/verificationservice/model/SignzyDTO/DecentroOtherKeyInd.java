package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroOtherKeyInd {
    private String ageOfOldestTrade;
    private String numberOfOpenTrades;
    private String allLinesEVERWritten;
    private String allLinesEVERWrittenIn9Months;
    private String allLinesEVERWrittenIn6Months;
}
