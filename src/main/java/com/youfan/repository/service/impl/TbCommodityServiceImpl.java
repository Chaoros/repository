package com.youfan.repository.service.impl;

import com.youfan.repository.vo.PieCharts;
import org.springframework.stereotype.Service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youfan.repository.domain.TbCommodity;
import com.youfan.repository.mapper.TbCommodityMapper;
import com.youfan.repository.service.TbCommodityService;

@Service
public class TbCommodityServiceImpl extends ServiceImpl<TbCommodityMapper, TbCommodity> implements TbCommodityService {
    //将dao中的接口传进来通过extends就实现了对数据业务的管理

    @Override
    public List<PieCharts> selectPieByCategory() {
        return baseMapper.selectPieByCategory();
    }

    @Override
    public List<PieCharts> selectLineChartsByRepository(String startDate, String endDate) {
        return baseMapper.selectLineChartsByRepository(startDate, endDate);
    }
}
