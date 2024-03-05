package com.yoleague.yo_league_be.service;

import com.yoleague.yo_league_be.model.ClubModel;

import java.util.List;

public interface ClubService {
    List<ClubModel> getAllClub();
    ClubModel saveClub(ClubModel clubModel);
}
