package com.example.servlet.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.servlet.entity.purchase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface purchaseMapper extends BaseMapper<purchase> {
}
