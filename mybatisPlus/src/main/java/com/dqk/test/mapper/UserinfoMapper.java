package com.dqk.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dqk.test.entity.Userinfo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dqk
 * @since 2021-01-17
 */
public interface UserinfoMapper extends BaseMapper<Userinfo> {

    List<Userinfo> selectList123545();
}
