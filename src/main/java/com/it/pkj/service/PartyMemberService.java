package com.it.pkj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.it.pkj.domain.PartyMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.it.pkj.domain.result.PartyMemberWithProvince;

import java.util.List;

/**
* @author Administrator
* @description 针对表【party_member】的数据库操作Service
* @createDate 2025-03-23 17:10:41
*/
public interface PartyMemberService extends IService<PartyMember> {
    // 查询所有党员信息
    IPage<PartyMemberWithProvince> getAllPartyMembers(int currentPage, int pageSize);
    // 党员查看自己的个人信息
    PartyMemberWithProvince getPartyMemberById(Integer id);
    // 修改党员信息
    boolean updatePartyMember(PartyMember partyMember);
}
