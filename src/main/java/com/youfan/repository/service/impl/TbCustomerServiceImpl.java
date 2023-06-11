package com.youfan.repository.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youfan.repository.domain.TbCustomer;
import com.youfan.repository.mapper.TbCustomerMapper;
import com.youfan.repository.service.TbCustomerService;
import org.springframework.stereotype.Service;

@Service
public class TbCustomerServiceImpl extends ServiceImpl<TbCustomerMapper, TbCustomer> implements TbCustomerService {
}
