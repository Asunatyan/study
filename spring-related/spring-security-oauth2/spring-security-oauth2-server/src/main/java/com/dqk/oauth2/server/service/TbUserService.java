package com.dqk.oauth2.server.service;

import com.dqk.oauth2.server.domain.TbUser;

public interface TbUserService{

    public TbUser getByUsername(String username);

}
