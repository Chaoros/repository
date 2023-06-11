package com.youfan.repository.service;

import com.youfan.repository.vo.CommodityRepository;
import com.youfan.repository.domain.TbRepository;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TbRepositoryService extends IService<TbRepository> {

    List<CommodityRepository> selectList(int type);
}
