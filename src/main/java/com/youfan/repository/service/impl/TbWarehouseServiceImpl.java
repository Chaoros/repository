package com.youfan.repository.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youfan.repository.domain.TbWarehouse;
import com.youfan.repository.mapper.TbWarehouseMapper;
import com.youfan.repository.service.TbWarehouseService;
import org.springframework.stereotype.Service;

@Service
public class TbWarehouseServiceImpl extends ServiceImpl<TbWarehouseMapper, TbWarehouse> implements TbWarehouseService {
}
