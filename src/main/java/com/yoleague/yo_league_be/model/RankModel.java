package com.yoleague.yo_league_be.model;

import com.yoleague.yo_league_be.entity.Rank;
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
    private ClubModel club;

    public RankModel(Rank rank) {
        this.played = rank.getPlayed();
        this.won = rank.getWon();
        this.lost = rank.getLost();
        this.drawn = rank.getDrawn();
        this.goalsFor = rank.getGoalsFor();
        this.goalsAgainst = rank.getGoalsAgainst();
        this.goalsDifference = rank.getGoalsDifference();
        this.points = rank.getPoints();
        this.club = new ClubModel(rank.getClub());
    }
}
