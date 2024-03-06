package com.yoleague.yo_league_be.entity;

import com.yoleague.yo_league_be.model.ClubModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "coach_name")
    private String coachName;

    @Column(name = "flag")
    private String flag;

    @Column(name = "coach_image")
    private String coachImage;

    @OneToMany(mappedBy = "club",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Rank> rank;

    @OneToMany(mappedBy = "homeClub",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Match> homeMatches;

    @OneToMany(mappedBy = "awayClub",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Match> awayMatches;

    public Club(Long id) {
        this.id = id;
    }

}
