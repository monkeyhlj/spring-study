package com.monkey.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.monkey.mybatisplus.enums.AgeEnum;
import com.monkey.mybatisplus.enums.StatusEbum;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
//    @TableField(value = "name",select = false)
    @TableField(value = "name")
    private String title;
//    private AgeEnum age;
    private Integer age;
    @TableField(exist = false)
    private String gender;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    private Integer version;
    private StatusEbum status;
    @TableLogic
    private Integer deleted;

//    private Product product;
}
