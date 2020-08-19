package com.monkey.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum StatusEbum {
    WORK(1,"上班"),
    REST(0,"休息");

    StatusEbum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @EnumValue
    private Integer code;
    private String msg;
}
