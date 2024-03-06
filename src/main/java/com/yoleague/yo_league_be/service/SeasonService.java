package com.yoleague.yo_league_be.service;

import com.yoleague.yo_league_be.model.SeasonModel;

import java.util.List;

public interface SeasonService {
    List<SeasonModel> getAllSeason();

    SeasonModel saveSeason(SeasonModel seasonModel);
}
