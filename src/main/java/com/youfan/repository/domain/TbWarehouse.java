package com.youfan.repository.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class TbWarehouse {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String detail;

}
