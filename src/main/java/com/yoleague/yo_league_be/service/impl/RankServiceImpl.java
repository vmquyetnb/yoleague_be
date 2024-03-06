package com.yoleague.yo_league_be.service.impl;

import com.yoleague.yo_league_be.entity.Club;
import com.yoleague.yo_league_be.entity.Rank;
import com.yoleague.yo_league_be.entity.Season;
import com.yoleague.yo_league_be.model.ClubModel;
import com.yoleague.yo_league_be.model.RankModel;
import com.yoleague.yo_league_be.model.SeasonModel;
import com.yoleague.yo_league_be.repository.ClubRepo;
import com.yoleague.yo_league_be.repository.RankRepo;
import com.yoleague.yo_league_be.repository.SeasonRepo;
import com.yoleague.yo_league_be.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private RankRepo rankRepo;

    @Autowired
    private ClubRepo clubRepo;

    @Autowired
    private SeasonRepo seasonRepo;

    @Override
    public List<RankModel> getAllRankBySeasonNewest() {
        List<RankModel> result = new ArrayList<>();
        List<Rank> ranks = rankRepo.findBySeasonNewest();
        for(Rank item : ranks){
            RankModel rankModel = new RankModel();
            rankModel.setClub(new ClubModel(item.getClub()));
            rankModel.setSeason(new SeasonModel(item.getSeason()));
            rankModel.setPlayed(item.getPlayed());
            rankModel.setWon(item.getWon());
            rankModel.setDrawn(item.getDrawn());
            rankModel.setLost(item.getLost());
            rankModel.setGoalsFor(item.getGoalsFor());
            rankModel.setGoalsAgainst(item.getGoalsAgainst());
            rankModel.setGoalsDifference(item.getGoalsDifference());
            rankModel.setPoints(item.getPoints());
            result.add(rankModel);
        }
        return result;
    }

    @Override
    public List<RankModel> getAllRankBySeasonId(Long id) {
        List<RankModel> result = new ArrayList<>();
        List<Rank> ranks = rankRepo.findBySeasonId(id);
        for(Rank item : ranks){
            RankModel rankModel = new RankModel();
            rankModel.setClub(new ClubModel(item.getClub()));
            rankModel.setSeason(new SeasonModel(item.getSeason()));
            rankModel.setPlayed(item.getPlayed());
            rankModel.setWon(item.getWon());
            rankModel.setDrawn(item.getDrawn());
            rankModel.setLost(item.getLost());
            rankModel.setGoalsFor(item.getGoalsFor());
            rankModel.setGoalsAgainst(item.getGoalsAgainst());
            rankModel.setGoalsDifference(item.getGoalsDifference());
            rankModel.setPoints(item.getPoints());
            result.add(rankModel);
        }
        return result;
    }

    @Override
    public RankModel saveRank(RankModel rankModel) {
        Rank rank = new Rank();
        Club club = clubRepo.findById(rankModel.getClub().getId()).orElse(null);
        rank.setClub(club);
        Season season = seasonRepo.findById(rankModel.getSeason().getId()).orElse(null);
        rank.setSeason(season);
        rank.setPlayed(0);
        rank.setWon(0);
        rank.setLost(0);
        rank.setDrawn(0);
        rank.setGoalsFor(0);
        rank.setGoalsAgainst(0);
        rank.setGoalsDifference(0);
        rank.setPoints(0);
        rankRepo.save(rank);

        rankModel.setClub(new ClubModel(rank.getClub()));
        rankModel.setSeason(new SeasonModel(rank.getSeason()));
        rankModel.setPlayed(rank.getPlayed());
        rankModel.setWon(rank.getWon());
        rankModel.setDrawn(rank.getDrawn());
        rankModel.setLost(rank.getLost());
        rankModel.setGoalsFor(rank.getGoalsFor());
        rankModel.setGoalsAgainst(rank.getGoalsAgainst());
        rankModel.setGoalsDifference(rank.getGoalsDifference());
        rankModel.setPoints(rank.getPoints());
        return rankModel;
    }
}
