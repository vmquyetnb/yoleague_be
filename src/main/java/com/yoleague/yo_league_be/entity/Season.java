package com.yoleague.yo_league_be.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "season")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "season",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Match> matches;

    @OneToMany(mappedBy = "season",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Rank> ranks;

    public Season (Long id){
        this.id = id;
    }
}
