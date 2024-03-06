package com.yoleague.yo_league_be.controller;

import com.yoleague.yo_league_be.model.ClubModel;
import com.yoleague.yo_league_be.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    @Autowired
    public ClubService clubService;

    @GetMapping("")
    public List<ClubModel> listClubs (){
        List<ClubModel> listClubs = clubService.getAllClub();
        return listClubs;
    }

    @PostMapping("/add")
    public ClubModel createClub(@RequestBody ClubModel clubModel){
        return clubService.saveClub(clubModel);
    }
}
