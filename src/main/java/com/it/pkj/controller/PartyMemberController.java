package com.it.pkj.controller;

import com.it.pkj.common.Result;
import com.it.pkj.domain.PartyMember;
import com.it.pkj.domain.SystemUser;
import com.it.pkj.service.PartyMemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: partyPayManage
 * @BelongsPackage: com.it.pkj.controller
 * @Author: kanimito
 * @CreateTime: 2025-03-23  13:44
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/partyMember")
public class PartyMemberController {

    @Autowired
    private PartyMemberService partyMemberService;
    // 管理党员信息
    // 1、查询党员信息
    @GetMapping("/list")
    public Result<List<PartyMember>> list() {
        List<PartyMember> list = partyMemberService.list();
        return Result.ok(list);
    }
    // 2、根据党员id修改党员信息
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody PartyMember partyMember) {
        boolean result = partyMemberService.updatePartyMember(partyMember);
        return Result.ok(result);
    }
    // 3、根据党员id删除党员信息
    @RequestMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        boolean result = partyMemberService.removeById(id);
        return Result.ok(result);
    }
    // 4、添加党员信息
    @RequestMapping("/add")
    public Result<Boolean> add(@RequestBody PartyMember partyMember) {
        boolean save = partyMemberService.save(partyMember);
        return Result.ok(save);
    }
    // 5、党员查看自己的个人信息
    @GetMapping("/info")
    public Result<PartyMember> info(Integer id, HttpServletRequest request) {
        SystemUser user = (SystemUser) request.getAttribute("user");
        PartyMember partyMember = partyMemberService.getById(user.getMemberId());
        return Result.ok(partyMember);
    }
}
