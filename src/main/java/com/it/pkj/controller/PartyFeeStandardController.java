package com.it.pkj.controller;

import com.it.pkj.common.Result;
import com.it.pkj.domain.PartyFeeStandard;
import com.it.pkj.service.PartyFeeStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: partyPayManage
 * @BelongsPackage: com.it.pkj.controller
 * @Author: kanimito
 * @CreateTime: 2025-03-23  16:18
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/partyFeeStandard")
public class PartyFeeStandardController {
    @Autowired
    private PartyFeeStandardService partyFeeStandardService;
    // 查询缴费标准
    @GetMapping("/get")
    public Result<List<PartyFeeStandard>> get() {
        List<PartyFeeStandard> list = partyFeeStandardService.list();
        return Result.ok(list);
    }
    // 修改缴费标准
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody PartyFeeStandard partyFeeStandard){
        boolean result = partyFeeStandardService.updatePartyFeeStandard(partyFeeStandard);
        return Result.ok(result);
    }
    // 添加缴费标准
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody PartyFeeStandard partyFeeStandard){
        boolean result = partyFeeStandardService.save(partyFeeStandard);
        return Result.ok(result);
    }
    // 删除缴费标准
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody PartyFeeStandard partyFeeStandard){
        boolean result = partyFeeStandardService.removeById(partyFeeStandard.getId());
        return Result.ok(result);
    }
}
