package com.scg.api.team;

import com.scg.datadto.FeedDataVo;
import com.scg.model.Team;
import com.scg.model.TeamApply;
import com.scg.model.TeamMember;
import com.scg.persistence.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sungbo on 2016-06-24.
 */
@Service
public class TeamService {

    @Autowired
    TeamMapper teamMapper;

    /*********************************************************
     *  Team
     *********************************************************/

    public ArrayList<String> getTeamNameList(){
        return teamMapper.getTeamNameList();
    }

    public int teamSave(Team team){
        return teamMapper.teamSave(team);
    };

    public void teamUpdate(Team team){
        teamMapper.teamUpdate(team);
    };

    public List<Team> getTeamList(Team team){

        return teamMapper.getTeamList(team);
    };

    public Team getTeam(Team team){
        return teamMapper.getTeam(team);
    };



    /*********************************************************
     *  Team Apply
     *********************************************************/

    public int teamApplySave(TeamApply apply){
        return teamMapper.teamApplySave(apply);
    };


    public void teamApplyUpdate(TeamApply apply){
        teamMapper.teamApplyUpdate(apply);
    };


    public int getTeamApplyCount(TeamApply apply){
        return teamMapper.getTeamApplyCount(apply);
    };


    public List<TeamApply> getTeamApplyList(TeamApply apply){
        return teamMapper.getTeamApplyList(apply);
    };

    public TeamApply getTeamApply(TeamApply apply){

        TeamApply teamApply = null;
        try{
            teamApply = teamMapper.getTeamApply(apply);
        }catch (Exception e){}

        if(teamApply==null){
            teamApply = new TeamApply();
        }

        return teamApply;
    };

    public void deleteTeamApply(TeamApply apply){
        teamMapper.deleteTeamApply(apply);
    };

    /*********************************************************
     *  Team member
     *********************************************************/
    public void saveTeamMember(TeamMember teamMember){
        teamMapper.saveTeamMember(teamMember);
    };
    public void updateTeamMember(TeamMember teamMember){
        teamMapper.updateTeamMember(teamMember);
    };
    public List<TeamMember> getTeamMemeberList(TeamMember teamMember){
        return teamMapper.getTeamMemeberList(teamMember);
    };


    public TeamMember getTeamMemeber(TeamMember teamMember){

        TeamMember member = null;
        try{
            member = teamMapper.getTeamMemeber(teamMember);
        }catch (Exception e){
        }

        if(member == null){
            member = new TeamMember();
        }

        return member;
    };

    public void deleteTeamMember(int teamid,int uid){
        teamMapper.deleteTeamMember(teamid,uid);
    };

    public List<TeamApply> getReqMember(int insid,String status){
        return teamMapper.getReqMember(insid, status);
    };

    public TeamMember getMyTeam(int uid){
        return teamMapper.getMyTeam(uid);
    };

    public Team getMyTeaminfo(int uid){

        Team team = null;

        try {
            team = teamMapper.getMyTeaminfo(uid);
        }catch (Exception e){

        }

        if(team == null){
            team = new Team();
        }

        return team;
    };

    public FeedDataVo getTeamCount(int insid){
        return teamMapper.getTeamCount(insid);
    };
}
