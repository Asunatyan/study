package com.dqk.oauth2.server.service.impl;

import com.dqk.oauth2.server.domain.TbPermission;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.dqk.oauth2.server.mapper.TbPermissionMapper;
import com.dqk.oauth2.server.service.TbPermissionService;

import java.util.List;

@Service
public class TbPermissionServiceImpl implements TbPermissionService {

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<TbPermission> selectUserPermissionByUserId(long userId) {
        return tbPermissionMapper.selectUserPermissionByUserId(userId);
    }
}

