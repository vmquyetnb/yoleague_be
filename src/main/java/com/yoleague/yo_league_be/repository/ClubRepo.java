package com.yoleague.yo_league_be.repository;

import com.yoleague.yo_league_be.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepo extends JpaRepository<Club,Long> {
}
