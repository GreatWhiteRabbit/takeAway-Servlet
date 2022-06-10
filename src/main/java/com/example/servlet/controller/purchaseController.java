package com.example.servlet.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.servlet.entity.purchase;
import com.example.servlet.service.Ipurchase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/purchase")
public class purchaseController {
    @Autowired
    private Ipurchase ipurchase;
    @PostMapping("/insertPurchase")
    public boolean insertPurchase(@RequestBody purchase purchase){
        System.out.println("insertPurchase =====>");
        System.out.println(purchase);
        return ipurchase.save(purchase);
    }

    @GetMapping("/getByuserid")
    public List<purchase> getByuserid( String userid){
        System.out.println("getByuserid ====>");
        System.out.println(userid);
        QueryWrapper<purchase> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userid",userid);
        return ipurchase.list(queryWrapper);
    }

    @GetMapping("/deletePurchase")
    public boolean deletePurchase(String userid,String goodsid){
        System.out.println("deletePurchase ====>");
        System.out.println(userid+"----"+goodsid);
        QueryWrapper<purchase> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userid",userid);
        queryWrapper.eq("goodsid",goodsid);
        return ipurchase.remove(queryWrapper);
    }

    @PostMapping ("/payPurchase")
    public boolean payPurchase(@RequestBody purchase purchase){
        System.out.println("payPurchase =====>");
        System.out.println(purchase);
        QueryWrapper<purchase> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("goodsid",purchase.getGoodsid());
        queryWrapper.eq("userid",purchase.getUserid());
       return ipurchase.update(purchase,queryWrapper);
    }

    @PostMapping("/sendPurchase")
    public boolean sendPurchase(@RequestBody purchase purchase){
        System.out.println("sendPurchase ====>");
        System.out.println(purchase);
        return true;
    }

    @GetMapping("/getAllPurchase")
    public List<purchase> getAllPurchase(){
        return ipurchase.list();
    }

    @PostMapping("/updateSendPurchase")
    public boolean updateSendPurchase(@RequestBody purchase purchase){
        System.out.println("updateSendPurchase ====>");
        System.out.println(purchase);
        QueryWrapper<purchase> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("goodsid",purchase.getGoodsid());
        queryWrapper.eq("userid",purchase.getUserid());
        return ipurchase.update(purchase,queryWrapper);
    }
}
