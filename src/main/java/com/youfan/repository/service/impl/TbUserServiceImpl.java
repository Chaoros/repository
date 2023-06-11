package com.youfan.repository.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youfan.repository.domain.TbUser;
import com.youfan.repository.mapper.TbUserMapper;
import com.youfan.repository.service.TbUserService;
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService{

}
