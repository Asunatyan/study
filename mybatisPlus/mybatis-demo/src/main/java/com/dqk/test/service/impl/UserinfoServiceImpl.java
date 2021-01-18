package com.dqk.test.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dqk.test.entity.Userinfo;
import com.dqk.test.mapper.UserinfoMapper;
import com.dqk.test.service.IUserinfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dqk
 * @since 2021-01-17
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements IUserinfoService {

}
