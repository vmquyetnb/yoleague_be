package com.yoleague.yo_league_be.service.impl;

import com.yoleague.yo_league_be.entity.Rank;
import com.yoleague.yo_league_be.entity.Season;
import com.yoleague.yo_league_be.model.SeasonModel;
import com.yoleague.yo_league_be.repository.SeasonRepo;
import com.yoleague.yo_league_be.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class SeasonServiceImpl implements SeasonService {

    @Autowired
    private SeasonRepo seasonRepo;

    @Override
    public List<SeasonModel> getAllSeason() {
        List<SeasonModel> result = new ArrayList<>();
        List<Season> seasons = seasonRepo.findAll();
        for(Season item : seasons){
            SeasonModel seasonModel = new SeasonModel();
            seasonModel.setName(item.getName());
            seasonModel.setStatus(item.getStatus());
            result.add(seasonModel);
        }
        return result;
    }

    @Override
    public SeasonModel getRankingSeasonNewest() {
        Season season = seasonRepo.getRankingSeasonNewest();
        return new SeasonModel(season);
    }

    @Override
    public SeasonModel saveSeason(SeasonModel seasonModel) {
        Season season = new Season();
        season.setName(seasonModel.getName());
        season.setStatus(0);
        seasonRepo.save(season);

        seasonModel.setName(season.getName());
        seasonModel.setStatus(season.getStatus());
        return seasonModel;
    }
}
