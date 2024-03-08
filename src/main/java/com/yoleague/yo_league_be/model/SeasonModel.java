package com.yoleague.yo_league_be.model;

import com.yoleague.yo_league_be.entity.Rank;
import com.yoleague.yo_league_be.entity.Season;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeasonModel {
    private Long id;
    private String name;
    private int status;

    private List<RankModel> ranks = new ArrayList<>();

    public  SeasonModel(Long id){
        this.id = id;
    }

    public SeasonModel (Season season){
        this.id = season.getId();
        this.name = season.getName();
        this.status = season.getStatus();
        for (Rank rank : season.getRanks()) {
            this.ranks.add(new RankModel(rank));
        }
    }
}
