package com.youfan.repository;

import com.youfan.repository.domain.TbCustomer;
import com.youfan.repository.service.impl.TbCustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class RepositoryApplicationTests {

    @Resource
    private TbCustomerServiceImpl tbCustomerService;
    @Test
    public void testSave(){
        TbCustomer customer=new TbCustomer();
        customer.setName("张丽");
        customer.setAddress("安阳");
        System.out.println(this.tbCustomerService.saveOrUpdate(customer));
    }
    @Test
    public void testDelete(){
        int id=2;
        System.out.println(this.tbCustomerService.removeById(id));
    }
    @Test
    public void testList(){
        List<TbCustomer> customers=this.tbCustomerService.list();
        for (TbCustomer customer : customers) {
            System.out.println(customer.getName()+":"+customer.getAddress());
        }
    }

}
