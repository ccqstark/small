package com.ccqstark.small.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccqstark.small.dao.UserMapper;
import com.ccqstark.small.model.User;
import com.ccqstark.small.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ccqstark
 * @since 2021-05-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
