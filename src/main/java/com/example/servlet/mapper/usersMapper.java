package com.example.servlet.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.servlet.entity.users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface usersMapper extends BaseMapper<users> {
}
