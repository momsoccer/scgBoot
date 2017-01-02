package com.scg.api.favoritemission;

import com.scg.model.Common.FavoriteMission;
import com.scg.model.Mission;
import com.scg.persistence.FavoriteMissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sungbo on 2016-08-08.
 */
@Service
public class FavoriteMissionService {

    @Autowired
    FavoriteMissionMapper mapper;

    public void saveFavoriteMission(FavoriteMission favoriteMission){
        mapper.saveFavoriteMission(favoriteMission);
    };
    public void deleteFavoriteMission(FavoriteMission favoriteMission){
        mapper.deleteFavoriteMission(favoriteMission);
    };
    public int getCountFavoriteMission(FavoriteMission favoriteMission){
        return mapper.getCountFavoriteMission(favoriteMission);
    };
    public List<FavoriteMission> getFavoriteList(FavoriteMission favoriteMission){
        return mapper.getFavoriteList(favoriteMission);
    };
    public FavoriteMission getFavorite(FavoriteMission favoriteMission){
        return mapper.getFavorite(favoriteMission);
    };

    public List<Mission> getFavoriteMissionList(Mission mission){
        return mapper.getFavoriteMissionList(mission);
    };
}
