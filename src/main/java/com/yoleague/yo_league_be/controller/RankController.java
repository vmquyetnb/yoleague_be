package com.yoleague.yo_league_be.controller;

import com.yoleague.yo_league_be.model.RankModel;
import com.yoleague.yo_league_be.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rank")
public class RankController {

    @Autowired
    public RankService rankService;

    @GetMapping("")
    public List<RankModel> getAllBySeason (@RequestParam(name = "seasonId" +
            "", required = false) Long id){
        List<RankModel> listRank ;
        if(id != null){
            listRank = rankService.getAllRankBySeasonId(id);
        }else {
            listRank = rankService.getAllRankBySeasonNewest();
        }
        return listRank;
    }

//    @PostMapping("/add")
//    public  RankModel saveRank (@RequestBody RankModel rankModel){
//        return rankService.saveRank(rankModel);
//    }
}
