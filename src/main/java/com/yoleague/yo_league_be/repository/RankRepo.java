package com.yoleague.yo_league_be.repository;

import com.yoleague.yo_league_be.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankRepo extends JpaRepository<Rank,Long> {
    @Query("SELECT r FROM Rank r WHERE r.season.id = (SELECT MAX(s.id) FROM Season s)")
    List<Rank> findBySeasonNewest();

    List<Rank> findBySeasonId (Long id);


}
