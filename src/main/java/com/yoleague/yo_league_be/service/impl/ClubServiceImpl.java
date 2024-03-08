package com.yoleague.yo_league_be.service.impl;

import com.yoleague.yo_league_be.entity.Club;
import com.yoleague.yo_league_be.model.ClubModel;
import com.yoleague.yo_league_be.repository.ClubRepo;
import com.yoleague.yo_league_be.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepo clubRepo;

    @Override
    public List<ClubModel> getAllClub() {
        return clubRepo.findAll().stream()
                .map(item -> {
                    ClubModel clubModel = new ClubModel();
                    clubModel.setId(item.getId());
                    clubModel.setName(item.getName());
                    clubModel.setCoachName(item.getCoachName());
                    clubModel.setFlag(item.getFlag());
                    clubModel.setLogo(item.getLogo());
                    clubModel.setCoachImage(item.getCoachImage());
                    return clubModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ClubModel saveClub(ClubModel clubModel) {
        Club club = new Club();
        club.setName(clubModel.getName());
        club.setCoachName(clubModel.getCoachName());
        club.setFlag(clubModel.getFlag());
        club.setCoachImage(clubModel.getCoachImage());
        club.setLogo(clubModel.getLogo());
        club = clubRepo.save(club);

        clubModel.setName(club.getName());
        clubModel.setCoachName(club.getCoachName());
        clubModel.setFlag(club.getFlag());
        clubModel.setLogo(club.getLogo());
        clubModel.setCoachImage(club.getCoachImage());
        return clubModel;
    }


}
