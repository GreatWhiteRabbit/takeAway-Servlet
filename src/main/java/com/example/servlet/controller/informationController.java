package com.example.servlet.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.servlet.entity.information;

import com.example.servlet.service.Iinformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/information")
public class informationController {
    @Autowired
    private Iinformation iinformation;
    @PostMapping("/selectAll")
    public List<information> selectAll(){
        return iinformation.list();
    }

    @GetMapping("/classify")
    public List<information> classify(@RequestParam String shopid1,String shopid2){
      Map map1=new HashMap();
        Map map2=new HashMap();
      map1.put("shopid",shopid1);
      map2.put("shopid",shopid2);
      List<information> info1=iinformation.listByMap(map1);
      List<information> info2=iinformation.listByMap(map2);
     info1.addAll(info2);
     return  info1;
    }

    @GetMapping("/sellerGetInfo")
    public List<information> sellerGetInfo(@RequestParam String shopid){
        QueryWrapper<information> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("shopid",shopid);
        return iinformation.list(queryWrapper);
    }

    @PostMapping("/deleteMenu")
    public boolean deleteMenu(@RequestBody information information){
        System.out.println("deleteMenu =====>");
        System.out.println(information);
        QueryWrapper<information> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("goodsid",information.getGoodsid());
       return iinformation.remove(queryWrapper);
    }

    @GetMapping("/search")
    public List<information> search(String goodsname){
        System.out.println("search =====>");
        System.out.println(goodsname);
        QueryWrapper<information> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("goodsname",goodsname);
        return iinformation.list(queryWrapper);
    }


    @RequestMapping("/updateImg")
    public boolean updateImg(@RequestParam("file") MultipartFile file) throws IOException {

        String path="E:\\web课设\\takeAway\\chileme\\src\\assets\\img\\food\\";
        String fileName=file.getOriginalFilename();
        String savePath=path+fileName;
        System.out.println("图片保存路径"+savePath);
        File newFile=new File(path);
        file.transferTo(new File(newFile,fileName));
        return true;
    }

    @PostMapping("/addInformation")
    public boolean addInformation(@RequestBody information information){
        System.out.println("addInformation ====>");
        System.out.println(information);
        return iinformation.save(information);
    }
}
