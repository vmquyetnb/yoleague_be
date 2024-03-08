package com.yoleague.yo_league_be.repository;

import com.yoleague.yo_league_be.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepo extends JpaRepository<Season,Long> {

    @Query("select s from Season s where s.id = (SELECT MAX(s.id) FROM Season s)")
    Season getRankingSeasonNewest();
}
