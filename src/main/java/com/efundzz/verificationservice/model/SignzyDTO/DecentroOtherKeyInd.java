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

    public String getAgeOfOldestTrade() {
        return ageOfOldestTrade;
    }

    public void setAgeOfOldestTrade(String ageOfOldestTrade) {
        this.ageOfOldestTrade = ageOfOldestTrade;
    }

    public String getNumberOfOpenTrades() {
        return numberOfOpenTrades;
    }

    public void setNumberOfOpenTrades(String numberOfOpenTrades) {
        this.numberOfOpenTrades = numberOfOpenTrades;
    }

    public String getAllLinesEVERWritten() {
        return allLinesEVERWritten;
    }

    public void setAllLinesEVERWritten(String allLinesEVERWritten) {
        this.allLinesEVERWritten = allLinesEVERWritten;
    }

    public String getAllLinesEVERWrittenIn9Months() {
        return allLinesEVERWrittenIn9Months;
    }

    public void setAllLinesEVERWrittenIn9Months(String allLinesEVERWrittenIn9Months) {
        this.allLinesEVERWrittenIn9Months = allLinesEVERWrittenIn9Months;
    }

    public String getAllLinesEVERWrittenIn6Months() {
        return allLinesEVERWrittenIn6Months;
    }

    public void setAllLinesEVERWrittenIn6Months(String allLinesEVERWrittenIn6Months) {
        this.allLinesEVERWrittenIn6Months = allLinesEVERWrittenIn6Months;
    }
}
