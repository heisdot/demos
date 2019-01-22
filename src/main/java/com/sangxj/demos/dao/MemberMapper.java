package com.sangxj.demos.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sangxj.demos.entity.Member;
import com.sangxj.demos.vo.DemosVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface MemberMapper extends BaseMapper<Member> {
    List<DemosVO> selectInit();
}
