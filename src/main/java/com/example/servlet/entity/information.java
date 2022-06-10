package com.example.servlet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data //主要是为了提高代码简洁，省去set和get方法
@TableName("information")
public class information {
    private double price;

    private  String address;

    private  String goodsname;

    private String  shopname;

    private String shopid;

    private String imgid;

    private String goodsid;

}
