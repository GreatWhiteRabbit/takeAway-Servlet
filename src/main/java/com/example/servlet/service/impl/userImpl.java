package com.example.servlet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.servlet.entity.users;
import com.example.servlet.mapper.usersMapper;
import com.example.servlet.service.Iusers;
import org.springframework.stereotype.Service;

@Service
public class userImpl extends ServiceImpl<usersMapper, users> implements Iusers {

}
