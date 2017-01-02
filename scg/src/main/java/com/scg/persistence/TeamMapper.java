package com.scg.persistence;

import com.scg.datadto.FeedDataVo;
import com.scg.model.Team;
import com.scg.model.TeamApply;
import com.scg.model.TeamMember;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sungbo on 2016-06-24.
 */
public interface TeamMapper {

    /*********************************************************
     *  Team
     *********************************************************/

    public ArrayList<String> getTeamNameList();

    public int teamSave(Team team);
    public void teamUpdate(Team team);
    public List<Team> getTeamList(Team team);
    public Team getTeam(Team team);

    public TeamMember getMyTeam(int uid);

    /*********************************************************
     *  Team Apply
     *********************************************************/

    public int teamApplySave(TeamApply apply);
    public void teamApplyUpdate(TeamApply apply);
    public int getTeamApplyCount(TeamApply apply);
    public List<TeamApply> getTeamApplyList(TeamApply apply);
    public TeamApply getTeamApply(TeamApply apply);

    public void deleteTeamApply(TeamApply apply);

    /*********************************************************
     *  Team member
     *********************************************************/
    public void saveTeamMember(TeamMember teamMember);
    public void updateTeamMember(TeamMember teamMember);
    public List<TeamMember> getTeamMemeberList(TeamMember teamMember);
    public TeamMember getTeamMemeber(TeamMember teamMember);
    public void deleteTeamMember(int teamid,int uid);


    public List<TeamApply> getReqMember(int insid,String status);

    public Team getMyTeaminfo(int uid);

    public FeedDataVo getTeamCount(int insid);

}
