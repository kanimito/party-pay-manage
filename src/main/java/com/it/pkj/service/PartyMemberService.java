package com.it.pkj.service;

import com.it.pkj.domain.PartyMember;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【party_member】的数据库操作Service
* @createDate 2025-03-22 20:59:31
*/
public interface PartyMemberService extends IService<PartyMember> {
    // 根据党员id修改党员
    boolean updatePartyMember(PartyMember partyMember);
}
