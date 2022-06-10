package com.example.servlet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data //主要是为了提高代码简洁，省去set和get方法
@TableName("purchase")
public class purchase {
    private String goodsid;
    private String userid;
    private String shopid;
    private int counter;
    private String send;
    private String pay;

}
