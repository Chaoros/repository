package com.youfan.repository.controller;

import com.youfan.repository.vo.PieCharts;
import com.youfan.repository.vo.R;
import com.youfan.repository.domain.TbCommodity;
import com.youfan.repository.service.TbCommodityService;
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

@RequestMapping("commodity")
@RestController
@CrossOrigin("*")
public class CommodityController {

    @Resource
    private TbCommodityService commodityService;

    @GetMapping("category/charts")
    public R<List<PieCharts>> categoryCharts() {
        return R.ok(commodityService.selectPieByCategory());
    }

    @GetMapping("repository/charts")
    public R<List<PieCharts>> repositoryCharts(String startDate, String endDate) {
        return R.ok(commodityService.selectLineChartsByRepository(startDate, endDate));
    }

    @GetMapping("list")
    public R<List<TbCommodity>> list() {
        return R.ok(commodityService.list());
    }

    @DeleteMapping("del/{id}")
    public R<Void> del(@PathVariable Integer id) {
        commodityService.removeById(id);
        return R.ok();
    }

    @PostMapping("insert")
    public R<Void> insertCommodity(@RequestBody TbCommodity commodity) {
        commodityService.saveOrUpdate(commodity);
        return R.ok();
    }


}
