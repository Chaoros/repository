package com.youfan.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youfan.repository.vo.CommodityRepository;
import com.youfan.repository.domain.TbRepository;

import java.util.List;

public interface TbRepositoryMapper extends BaseMapper<TbRepository> {

    List<CommodityRepository> selectByType(int type);

}