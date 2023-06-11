package com.youfan.repository.service.impl;

import com.youfan.repository.vo.CommodityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youfan.repository.domain.TbRepository;
import com.youfan.repository.mapper.TbRepositoryMapper;
import com.youfan.repository.service.TbRepositoryService;

@Service
public class TbRepositoryServiceImpl extends ServiceImpl<TbRepositoryMapper, TbRepository> implements TbRepositoryService {

    @Override
    public List<CommodityRepository> selectList(int type) {
        return baseMapper.selectByType(type);
    }
}
