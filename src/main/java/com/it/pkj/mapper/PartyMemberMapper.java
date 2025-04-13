package com.it.pkj.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.pkj.domain.PartyMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.pkj.domain.result.PartyMemberWithProvince;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author Administrator
* @description 针对表【party_member】的数据库操作Mapper
* @createDate 2025-03-23 17:10:41
* @Entity com.it.pkj.domain.PartyMember
*/
public interface PartyMemberMapper extends BaseMapper<PartyMember> {
    /**
     * 联合查询党员信息和省份信息
     * @return 包含党员和省份信息的列表
     */
    @Select("SELECT pm.id, pm.name, pm.gender, pm.age, pm.join_party_time, pm.phone, pm.email, pm.organization_type, p.province_name " +
            "FROM party_member pm " +
            "LEFT JOIN province p ON pm.province_id = p.id")
    IPage<PartyMemberWithProvince> selectPartyMembersWithProvince(Page<PartyMemberWithProvince> page);

    /**
     * 根据党员id查询党员信息和省份信息
     * @param id 党员id
     * @return 包含党员和省份信息的对象
     */
    @Select("SELECT pm.id, pm.name, pm.gender, pm.age, pm.join_party_time, pm.phone, pm.email, pm.organization_type, p.province_name " +
            "FROM party_member pm " +
            "LEFT JOIN province p ON pm.province_id = p.id " +
            "WHERE pm.id = #{id}")
    PartyMemberWithProvince getPartyMemberById(@Param("id") Integer id);
}




