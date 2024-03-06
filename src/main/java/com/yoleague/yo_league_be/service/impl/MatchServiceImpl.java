package com.yoleague.yo_league_be.service.impl;

import com.yoleague.yo_league_be.entity.Club;
import com.yoleague.yo_league_be.entity.Match;
import com.yoleague.yo_league_be.entity.Season;
import com.yoleague.yo_league_be.model.ClubModel;
import com.yoleague.yo_league_be.model.MatchModel;
import com.yoleague.yo_league_be.model.SeasonModel;
import com.yoleague.yo_league_be.repository.ClubRepo;
import com.yoleague.yo_league_be.repository.MatchRepo;
import com.yoleague.yo_league_be.repository.SeasonRepo;
import com.yoleague.yo_league_be.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepo matchRepo;

    @Autowired
    private ClubRepo clubRepo;

    @Autowired
    private SeasonRepo seasonRepo;

    @Override
    public List<MatchModel> getAllMatch() {
        List<MatchModel> result = new ArrayList<>();
        List<Match> matches = matchRepo.findAll();
        for(Match item : matches){
            MatchModel matchModel = new MatchModel();
            matchModel.setHomeClub(new ClubModel(item.getHomeClub()));
            matchModel.setAwayClub(new ClubModel(item.getAwayClub()));
            matchModel.setHomeGoals(item.getHomeGoals());
            matchModel.setAwayGoals(item.getAwayGoals());
            matchModel.setDate(item.getDate());
            matchModel.setStatus(item.getStatus());
            matchModel.setSeason(new SeasonModel(item.getSeason()));
            result.add(matchModel);
        }
        return result;
    }

    @Override
    public MatchModel saveMatch(MatchModel matchModel) {
            try {
                Optional<Match> existingMatch = matchRepo.findByHomeClubIdAndAwayClubIdAndSeasonId(matchModel.getHomeClub().getId(), matchModel.getAwayClub().getId(),matchModel.getSeason().getId());

                if (existingMatch.isPresent()) {
                    // Nếu trận đấu đã tồn tại, đánh dấu là đã diễn ra trong mùa này
                    System.out.println("Trận đấu đã tồn tại trong mùa này.");
                } else {
                    Match match = new Match();
                    Club homeClub = clubRepo.findById(matchModel.getHomeClub().getId()).orElse(null);
                    match.setHomeClub(homeClub);

                    Club awayClub = clubRepo.findById(matchModel.getAwayClub().getId()).orElse(null);
                    match.setAwayClub(awayClub);

                    match.setHomeGoals(0);
                    match.setAwayGoals(0);
                    match.setDate(new Date());
                    match.setStatus(0);

                    Season season = seasonRepo.findById(matchModel.getSeason().getId()).orElse(null);
                    match.setSeason(season);

                    matchRepo.save(match);

                    matchModel.setHomeClub(new ClubModel(match.getHomeClub()));
                    matchModel.setAwayClub(new ClubModel(match.getAwayClub()));
                    matchModel.setHomeGoals(match.getHomeGoals());
                    matchModel.setAwayGoals(match.getAwayGoals());
                    matchModel.setDate(match.getDate());
                    matchModel.setStatus(match.getStatus());
                    matchModel.setSeason(new SeasonModel(match.getSeason()));
                }
                return matchModel;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
}
