package com.yoleague.yo_league_be.service;

import com.yoleague.yo_league_be.model.MatchModel;

import java.util.List;

public interface MatchService {
    List<MatchModel> getAllMatch();

    List<MatchModel> getAllMatchesToday();

    MatchModel saveMatch(MatchModel matchModel);
}
