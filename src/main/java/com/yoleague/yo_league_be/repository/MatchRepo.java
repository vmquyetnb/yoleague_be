package com.yoleague.yo_league_be.repository;

import com.yoleague.yo_league_be.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchRepo extends JpaRepository<Match,Long> {
    @Query("SELECT m FROM Match m WHERE m.homeClub.id = :homeClubId AND m.awayClub.id = :awayClubId AND m.season.id = :seasonId")
    Optional<Match> findByHomeClubIdAndAwayClubIdAndSeasonId(Long homeClubId, Long awayClubId,Long seasonId);
}
