package com.youfan.repository.controller;

import com.youfan.repository.domain.TbCustomer;
import com.youfan.repository.service.TbCustomerService;
import com.youfan.repository.vo.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("customer")
@RestController
@CrossOrigin("*")
public class CustomerController {
    @Resource
    private TbCustomerService customerService;

    @GetMapping("list")
    public R<List<TbCustomer>> list(){
        return R.ok(customerService.list());
    }

    @DeleteMapping("del/{id}")
    public R<Void> delCustomer(@PathVariable Integer id){
        customerService.removeById(id);
        return R.ok();
    }

    @PostMapping("save")
    public R<Void> saveCustomer(@RequestBody TbCustomer customer){
        customerService.saveOrUpdate(customer);
        return R.ok();
    }
}
