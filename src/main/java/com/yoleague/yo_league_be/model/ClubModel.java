package com.yoleague.yo_league_be.model;

import com.yoleague.yo_league_be.entity.Club;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClubModel {
    private Long id;
    private String name;
    private String coachName;
    private String flag;
    private String logo;
    private String coachImage;

    public ClubModel(Long id){
        this.id = id;
    }

    public ClubModel(Club club){
        this.id = club.getId();
        this.name = club.getName();
        this.coachName = club.getCoachName();
        this.flag = club.getFlag();
        this.logo = club.getLogo();
        this.coachImage = club.getCoachImage();
    }
}
