package com.youfan.repository.service;

import com.youfan.repository.vo.PieCharts;
import com.youfan.repository.domain.TbCommodity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TbCommodityService extends IService<TbCommodity> {
    //IService简化了业务层

    List<PieCharts> selectPieByCategory();

    List<PieCharts> selectLineChartsByRepository(String startDate, String endDate);
}
