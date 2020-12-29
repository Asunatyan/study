package com.dqk.oauth2.server.mapper;

import com.dqk.oauth2.server.domain.TbPermission;
import org.apache.ibatis.annotations.Param;import tk.mybatis.mapper.MyMapper;import java.util.List;

public interface TbPermissionMapper extends MyMapper<TbPermission> {
    List<TbPermission> selectUserPermissionByUserId(@Param("userId") long userId);
}