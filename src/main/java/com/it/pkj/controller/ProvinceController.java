package com.it.pkj.controller;

import com.it.pkj.common.Result;
import com.it.pkj.domain.Province;
import com.it.pkj.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject: partyPayManage
 * @BelongsPackage: com.it.pkj.controller
 * @Author: kanimito
 * @CreateTime: 2025-04-01  07:08
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @GetMapping("/list")
    public Result<List<Province>> list() {
        List<Province> list = provinceService.list();
        return Result.ok(list);
    }
}
