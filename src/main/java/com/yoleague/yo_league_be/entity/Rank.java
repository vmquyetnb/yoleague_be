package com.yoleague.yo_league_be.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "football_rank")
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "played")
    private int played;

    @Column(name = "won")
    private int won;

    @Column(name = "lost")
    private int lost;

    @Column(name = "drawn")
    private int drawn;

    @Column(name = "goals_for")
    private int goalsFor;

    @Column(name = "goals_against")
    private int goalsAgainst;

    @Column(name = "goals_difference")
    private int goalsDifference;

    @Column(name = "points")
    private int points;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "season_id")
    private Season season;
}
