package com.youfan.repository.controller;

import com.youfan.repository.vo.CommodityRepository;
import com.youfan.repository.vo.R;
import com.youfan.repository.domain.TbCommodity;
import com.youfan.repository.domain.TbRepository;
import com.youfan.repository.service.TbCommodityService;
import com.youfan.repository.service.TbRepositoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RequestMapping("repository")
@RestController
@CrossOrigin("*")
public class RepositoryController {

    @Resource
    private TbRepositoryService repositoryService;
    @Resource
    private TbCommodityService commodityService;

    @GetMapping("list/{type}")
    public R<List<CommodityRepository>> list(@PathVariable Integer type) {
        return R.ok(repositoryService.selectList(type));
    }

    @PostMapping("insert")
    public R<Void> insertRepository(@RequestBody TbRepository repository) {
//        repository.setUserId(1);
        repository.setRepositoryTime(new Date());

        TbCommodity commodity = commodityService.getById(repository.getCommodityId());

        // 入库
        if (repository.getType().equals(1)) {
            commodity.setNumber(commodity.getNumber() + repository.getNumber());
        }
        // 出库
        else {
            if (commodity.getNumber() < repository.getNumber()) {
                return R.fail("库存不足，出库失败！");
            } else {
                commodity.setNumber(commodity.getNumber() - repository.getNumber());
            }
        }

        commodityService.updateById(commodity);
        repositoryService.save(repository);
        return R.ok();
    }


}
