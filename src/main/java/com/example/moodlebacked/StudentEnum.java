package com.example.moodlebacked;

import lombok.Getter;

@Getter
public enum StudentEnum {
        has_register(1,"该学生已经存在"),
        register_success(2,"注册成功"),
        not_exist(3,"该学生不存在");
        private Integer code;
        private String msg;

        StudentEnum(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
