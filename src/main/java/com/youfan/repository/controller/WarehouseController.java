package com.youfan.repository.controller;

import com.youfan.repository.vo.R;
import com.youfan.repository.domain.TbWarehouse;
import com.youfan.repository.service.TbWarehouseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("warehouse")
@RestController
@CrossOrigin("*")
public class WarehouseController {

    @Resource
    private TbWarehouseService warehouseService;

    @GetMapping("list")
    public R<List<TbWarehouse>> list() {
        return R.ok(warehouseService.list());
    }

    @DeleteMapping("del/{id}")
    public R<Void> delWarehouse(@PathVariable Integer id) {
        warehouseService.removeById(id);
        return R.ok();
    }

    @PostMapping("save")
    public R<Void> saveWarehouse(@RequestBody TbWarehouse warehouse) {
        warehouseService.saveOrUpdate(warehouse);
        return R.ok();
    }

}
