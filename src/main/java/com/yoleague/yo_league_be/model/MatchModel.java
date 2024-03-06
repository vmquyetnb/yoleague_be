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
    private Integer homeGoals;
    private Integer awayGoals;
    private Date date;
    private Integer status;
    private SeasonModel season;

    public MatchModel(Match match) {
        this.homeClub = new ClubModel(match.getHomeClub());
        this.awayClub = new ClubModel(match.getAwayClub());
        this.homeGoals = match.getHomeGoals();
        this.awayGoals = match.getAwayGoals();
        this.date = match.getDate();
        this.status = match.getStatus();
        this.season = new SeasonModel(match.getSeason());
    }
}
