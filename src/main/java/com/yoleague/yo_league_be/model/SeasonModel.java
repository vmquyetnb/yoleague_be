package com.yoleague.yo_league_be.model;

import com.yoleague.yo_league_be.entity.Season;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeasonModel {
    private Long id;
    private String name;
    private int status;

    public  SeasonModel(Long id){
        this.id = id;
    }

    public SeasonModel (Season season){
        this.id = season.getId();
        this.name = season.getName();
        this.status = season.getStatus();
    }
}
