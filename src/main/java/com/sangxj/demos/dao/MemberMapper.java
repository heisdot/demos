package com.sangxj.demos.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sangxj.demos.entity.Member;
import com.sangxj.demos.vo.DemosVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @描述:
 * @创建人 coinko
 * @创建时间 2019/1/3
 */
@Mapper
public interface MemberMapper extends BaseMapper<Member> {
    List<DemosVO> selectInit();
}
