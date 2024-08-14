package com.wt.friendship.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.friendship.mapper.UserTeamMapper;
import com.wt.friendship.model.domain.UserTeam;
import com.wt.friendship.service.UserTeamService;
import org.springframework.stereotype.Service;

/**
* @author wt
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService {

}




