package com.wt.friendship.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.friendship.model.domain.Team;
import com.wt.friendship.model.domain.User;
import com.wt.friendship.model.dto.TeamQuery;
import com.wt.friendship.model.request.TeamJoinRequest;
import com.wt.friendship.model.request.TeamQuitRequest;
import com.wt.friendship.model.request.TeamUpdateRequest;
import com.wt.friendship.model.vo.TeamUserVo;

import java.util.List;

/**
* @author wt
* @description 针对表【team(队伍)】的数据库操作Service
*/
public interface TeamService extends IService<Team> {

    long addTeam(Team team, User loginUser);

    List<TeamUserVo> listTeams(TeamQuery teamQuery, boolean isAdmin);

    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    boolean deleteTeam(long id, User loginUser);
}
