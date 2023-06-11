package com.youfan.repository.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "tb_repository")
public class TbRepository {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品ID
     */
    @TableField(value = "commodity_id")
    private Integer commodityId;

    /**
     * 入库数量/出库数量
     */
    @TableField(value = "number")
    private Integer number;

    /**
     * 出库时间/入库时间
     */
    @TableField(value = "repository_time")
    private Date repositoryTime;

    /**
     * 0出库；1入库
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    public static final String COL_ID = "id";

    public static final String COL_COMMODITY_ID = "commodity_id";

    public static final String COL_NUMBER = "number";

    public static final String COL_REPOSITORY_TIME = "repository_time";

    public static final String COL_TYPE = "type";

    public static final String COL_USER_ID = "user_id";
}