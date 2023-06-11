package com.youfan.repository.vo;

import lombok.Data;

@Data
public class UserInfo {

    private String[] roles;
    private String name;
    private String avatar = "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif";
    private String introduction = "欢迎你来到仓库管理系统";

    public UserInfo(String name) {
        this.name = name;
    }
}
