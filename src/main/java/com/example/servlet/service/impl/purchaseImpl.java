package com.example.servlet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.servlet.entity.purchase;
import com.example.servlet.mapper.purchaseMapper;
import com.example.servlet.service.Ipurchase;
import org.springframework.stereotype.Service;

@Service
public class purchaseImpl extends ServiceImpl<purchaseMapper , purchase> implements Ipurchase {
}
