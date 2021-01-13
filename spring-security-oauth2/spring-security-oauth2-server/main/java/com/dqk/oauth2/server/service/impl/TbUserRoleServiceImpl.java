package com.dqk.oauth2.server.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.dqk.oauth2.server.mapper.TbUserRoleMapper;
import com.dqk.oauth2.server.service.TbUserRoleService;
@Service
public class TbUserRoleServiceImpl implements TbUserRoleService{

    @Resource
    private TbUserRoleMapper tbUserRoleMapper;

}
