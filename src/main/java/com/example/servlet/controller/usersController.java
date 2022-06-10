package com.example.servlet.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.servlet.entity.users;
import com.example.servlet.service.Iusers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/users")
public class usersController {
    @Autowired
    private Iusers iusers;
   @GetMapping("/login")
    public boolean login(@RequestParam String userid, String password,String status){
       QueryWrapper<users> queryWrapper=new QueryWrapper<>();
       queryWrapper.eq("userid",userid);
       queryWrapper.eq("password",password);
       queryWrapper.eq("status",status);
       users users=iusers.getOne(queryWrapper);
       if(users==null)
           return false;
       return true;
   }
   @GetMapping("/register")
    public boolean register(@RequestParam String userid,String password){
       System.out.println("register ====>");
       System.out.println(userid +" " +password);
       users use=new users();
       use.setPassword(password);
       use.setStatus("no");
       use.setUserid(userid);
       return iusers.save(use);
    }
    @GetMapping("/sellerLogin")
    public boolean sellerLogin(@RequestParam String userid,String password,String status){
        QueryWrapper<users> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userid",userid);
        queryWrapper.eq("password",password);
        queryWrapper.eq("status",status);
        users users=iusers.getOne(queryWrapper);
        if(users==null)
            return false;
        return true;
    }
    @GetMapping("/sellerRegister")
    public boolean  sellerRegister(@RequestParam String userid,String password){
        System.out.println("sellerRegister ====>");
        System.out.println(userid +" " +password);
        users use=new users();
        use.setPassword(password);
        use.setStatus("yes");
        use.setUserid(userid);
        return iusers.save(use);
    }

}
