package com.yoleague.yo_league_be.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "football_match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_club_id" ,referencedColumnName = "id")
    private Club homeClub;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "away_club_id",referencedColumnName = "id")
    private Club awayClub;

    @Column(name = "home_goals")
    private int homeGoals;

    @Column(name = "away_goals")
    private int awayGoals;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private int status;

}
