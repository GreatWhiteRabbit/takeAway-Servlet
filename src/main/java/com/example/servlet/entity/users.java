package com.example.servlet.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data //主要是为了提高代码简洁，省去set和get方法
@TableName("users")
public class users {
    private String userid;
    private String password;
    private String status;
}
