package com.yoleague.yo_league_be.service;

import com.yoleague.yo_league_be.model.MatchModel;

import java.util.List;

public interface MatchService {
    List<MatchModel> getAllMatch();

    MatchModel saveMatch(MatchModel matchModel);
}
