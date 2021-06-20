package com.hys.pagehelperplus.demo.service.impl;

import com.hys.pagehelperplus.demo.entity.UserDO;
import com.hys.pagehelperplus.demo.entity.UserVO;
import com.hys.pagehelperplus.demo.manager.UserManager;
import com.hys.pagehelperplus.demo.util.mapstruct.UserListMapper;
import com.hys.pagehelperplus.demo.service.UserService;
import com.hys.pagehelperplus.entity.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户服务接口实现
 *
 * @author Robert Hou
 * @since 2020年11月27日 21:47
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public Pager<UserVO> list(int pageNum, int pageSize) {
        Pager<UserDO> pager = userManager.list(pageNum, pageSize);
        return UserListMapper.INSTANCE.userDO2VOList(pager);
    }
}
