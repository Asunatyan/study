package com.dqk.oauth2.server.service;

import com.dqk.oauth2.server.domain.TbPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPermissionService {
    List<TbPermission> selectUserPermissionByUserId(long userId);

}

