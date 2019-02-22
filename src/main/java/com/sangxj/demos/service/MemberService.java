package com.sangxj.demos.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangxj.demos.entity.Member;

import java.util.List;

public interface MemberService extends IService<Member> {
    List<Member> selectListMembers();
}
