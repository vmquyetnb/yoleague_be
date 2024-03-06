package com.yoleague.yo_league_be.controller;

import com.yoleague.yo_league_be.model.MatchModel;
import com.yoleague.yo_league_be.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("")
    public List<MatchModel> getAllMatch () {
        return matchService.getAllMatch();
    }

    @PostMapping("/add")
    public MatchModel saveMatch (@RequestBody MatchModel matchModel){
        return matchService.saveMatch(matchModel);
    }
}
