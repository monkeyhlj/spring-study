package com.monkey.mybatisplus.your.service.impl;

import com.monkey.mybatisplus.your.entity.User;
import com.monkey.mybatisplus.your.mapper.UserMapper;
import com.monkey.mybatisplus.your.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hhhmonkey
 * @since 2020-08-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
