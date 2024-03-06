package com.yoleague.yo_league_be.controller;

import com.yoleague.yo_league_be.model.SeasonModel;
import com.yoleague.yo_league_be.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/season")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @GetMapping("")
    public List<SeasonModel> getAllSeason (){
        List<SeasonModel> listSeason = seasonService.getAllSeason();
        return listSeason;
    }

    @PostMapping("/add")
    public SeasonModel saveSeason (@RequestBody SeasonModel seasonModel){
        return seasonService.saveSeason(seasonModel);
    }

}
