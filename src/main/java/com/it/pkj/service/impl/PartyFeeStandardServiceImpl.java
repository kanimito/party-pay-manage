package com.it.pkj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.pkj.domain.PartyFeeStandard;
import com.it.pkj.service.PartyFeeStandardService;
import com.it.pkj.mapper.PartyFeeStandardMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【party_fee_standard】的数据库操作Service实现
* @createDate 2025-03-23 17:10:41
*/
@Service
public class PartyFeeStandardServiceImpl extends ServiceImpl<PartyFeeStandardMapper, PartyFeeStandard>
    implements PartyFeeStandardService{

    @Override
    public boolean updatePartyFeeStandard(PartyFeeStandard partyFeeStandard) {
        int result = baseMapper.updateById(partyFeeStandard);
        return result > 0;
    }
}




