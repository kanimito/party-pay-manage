package com.it.pkj.controller;

import com.it.pkj.common.Result;
import com.it.pkj.domain.PartyFeePayment;
import com.it.pkj.domain.SystemUser;
import com.it.pkj.service.PartyFeePaymentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject: partyPayManage
 * @BelongsPackage: com.it.pkj.controller
 * @Author: kanimito
 * @CreateTime: 2025-03-23  16:16
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/paymentManagement")
public class PaymentManagementController {
    @Autowired
    private PartyFeePaymentService partyFeePaymentService;
    // 党费缴纳
    // 管理员查询缴费记录
    @GetMapping("/get")
    public Result<List<PartyFeePayment>> get() {
        List<PartyFeePayment> list = partyFeePaymentService.list();
        return Result.ok(list);
    }
    // 党员查看自己的缴费记录
    @GetMapping("/info")
    public Result<PartyFeePayment> info(HttpServletRequest request) {
        SystemUser user = (SystemUser) request.getAttribute("user");
        PartyFeePayment result = partyFeePaymentService.getById(user.getMemberId());
        return Result.ok(result);
    }
    // 生成党费缴纳报表
}
