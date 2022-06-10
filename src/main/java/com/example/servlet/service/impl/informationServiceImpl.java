package com.example.servlet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.servlet.entity.information;
import com.example.servlet.mapper.informationMapper;
import com.example.servlet.service.Iinformation;
import org.springframework.stereotype.Service;

@Service
public class informationServiceImpl extends ServiceImpl<informationMapper, information> implements Iinformation {

}
