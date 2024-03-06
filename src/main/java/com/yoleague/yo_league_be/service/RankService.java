package com.yoleague.yo_league_be.service;

import com.yoleague.yo_league_be.model.RankModel;

import java.util.List;

public interface RankService {
    List<RankModel> getAllRankBySeasonNewest();

    List<RankModel> getAllRankBySeasonId(Long id);

    RankModel saveRank(RankModel rankModel);
}
