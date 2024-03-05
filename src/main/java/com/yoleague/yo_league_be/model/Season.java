package com.yoleague.yo_league_be.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Season {
    private Long id;
    private String name;
    private int status;
}
