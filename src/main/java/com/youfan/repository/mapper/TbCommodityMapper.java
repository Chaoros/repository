package com.youfan.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youfan.repository.vo.PieCharts;
import com.youfan.repository.domain.TbCommodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCommodityMapper extends BaseMapper<TbCommodity> {
    //BaseMapper简化了数据层


    List<PieCharts> selectPieByCategory();//自定义的方法，手写映射文件下面mapper中

    List<PieCharts> selectLineChartsByRepository(@Param("startDate") String startDate,@Param("endDate") String endDate);

}