package com.yoleague.yo_league_be.model;

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
    private String coachImage;
}
