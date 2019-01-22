package com.sangxj.demos.service.Impl;


import com.sangxj.demos.entity.Member;
import com.sangxj.demos.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MemberServiceImpl implements MemberService {
    @Override
    public List<Member> selectListMembers() {
        return null;
    }
}
