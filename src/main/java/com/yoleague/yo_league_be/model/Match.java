package com.yoleague.yo_league_be.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    private Long id;
    private ClubModel homeClub;
    private ClubModel awayClub;
    private int homeGoals;
    private int awayGoals;
    private Date date;
    private int status;
}
