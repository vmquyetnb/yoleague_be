package com.yoleague.yo_league_be.model;

import com.yoleague.yo_league_be.entity.Club;
import com.yoleague.yo_league_be.entity.Match;
import com.yoleague.yo_league_be.entity.Season;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchModel {
    private ClubModel homeClub;
    private ClubModel awayClub;
    private int homeGoals;
    private int awayGoals;
    private Date date;
    private int status;
    private SeasonModel season;
}
