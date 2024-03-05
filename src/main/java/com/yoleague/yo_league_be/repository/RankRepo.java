package com.yoleague.yo_league_be.repository;

import com.yoleague.yo_league_be.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepo extends JpaRepository<Rank,Long> {
}
