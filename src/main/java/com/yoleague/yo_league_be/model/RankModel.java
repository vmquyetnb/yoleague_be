package com.yoleague.yo_league_be.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RankModel {
    private int played;
    private int won;
    private int lost;
    private int drawn;
    private int goalsFor;
    private int goalsAgainst;
    private int goalsDifference;
    private int points;
    private List<ClubModel> club;
    private SeasonModel season;
}
