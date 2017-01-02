package com.scg.api.favoritemission;

import com.scg.model.Common.FavoriteMission;
import com.scg.model.Common.ServerResult;
import com.scg.model.Mission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sungbo on 2016-08-08.
 */
@RestController
@RequestMapping("/api/common/")
public class FavoriteMissionController {

    private static final Logger logger = LoggerFactory.getLogger(FavoriteMissionController.class);

    @Autowired
    private FavoriteMissionService favoriteMissionService;

    @RequestMapping(value = "saveFavoriteMission" , method = RequestMethod.POST)
    public ServerResult saveFavoriteMission(@RequestBody FavoriteMission favoriteMission){
        favoriteMissionService.saveFavoriteMission(favoriteMission);
        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "deleteFavoriteMission" , method = RequestMethod.POST)
    public ServerResult deleteFavoriteMission(@RequestBody FavoriteMission favoriteMission){
        favoriteMissionService.deleteFavoriteMission(favoriteMission);
        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "getCountFavoriteMission" , method = RequestMethod.POST)
    public ServerResult getCountFavoriteMission(@RequestBody FavoriteMission favoriteMission){
        return new ServerResult(favoriteMissionService.getCountFavoriteMission(favoriteMission),"S");
    }

    @RequestMapping(value = "getFavoriteList" , method = RequestMethod.POST)
    public List<FavoriteMission> getFavoriteList(@RequestBody FavoriteMission favoriteMission){
        return favoriteMissionService.getFavoriteList(favoriteMission);
    }

    @RequestMapping(value = "getFavorite" , method = RequestMethod.POST)
    public FavoriteMission getFavorite(@RequestBody FavoriteMission favoriteMission){
        return favoriteMissionService.getFavorite(favoriteMission);
    }

    @RequestMapping(value = "getFavoriteMissionList" , method = RequestMethod.POST)
    public List<Mission> getFavoriteMissionList(@RequestBody Mission mission){
        return favoriteMissionService.getFavoriteMissionList(mission);
    }

}
