package com.it.pkj.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.pkj.domain.PartyMember;
import com.it.pkj.domain.result.PartyMemberWithProvince;
import com.it.pkj.service.PartyMemberService;
import com.it.pkj.mapper.PartyMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【party_member】的数据库操作Service实现
* @createDate 2025-03-23 17:10:41
*/
@Service
public class PartyMemberServiceImpl extends ServiceImpl<PartyMemberMapper, PartyMember>
    implements PartyMemberService{
    @Autowired
    private PartyMemberMapper partyMemberMapper;
    @Override
    public IPage<PartyMemberWithProvince> getAllPartyMembers(int currentPage, int pageSize) {
        Page<PartyMemberWithProvince> page = new Page<>(currentPage, pageSize);
        return partyMemberMapper.selectPartyMembersWithProvince(page);
    }

    @Override
    public PartyMemberWithProvince getPartyMemberById(Integer id) {
        PartyMemberWithProvince partyMemberById = partyMemberMapper.getPartyMemberById(id);
        return partyMemberById;
    }

    @Override
    public boolean updatePartyMember(PartyMember partyMember) {
        int result = baseMapper.updateById(partyMember);
        return result > 0;
    }
}




