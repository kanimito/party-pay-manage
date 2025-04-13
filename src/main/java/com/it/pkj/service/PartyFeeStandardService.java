package com.it.pkj.service;

import com.it.pkj.domain.PartyFeeStandard;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【party_fee_standard】的数据库操作Service
* @createDate 2025-03-23 17:10:41
*/
public interface PartyFeeStandardService extends IService<PartyFeeStandard> {

    boolean updatePartyFeeStandard(PartyFeeStandard partyFeeStandard);
}
