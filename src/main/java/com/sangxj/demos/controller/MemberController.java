package com.sangxj.demos.controller;

import com.sangxj.demos.dao.MemberMapper;
import com.sangxj.demos.entity.Member;
import com.sangxj.demos.vo.RestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @描述:
 * @创建人 coinko
 * @创建时间 2019/1/3
 */
@RestController
@RequestMapping(value = "/Test", produces = "application/json;charset=utf-8")
@Api(description = "Test")
public class MemberController {

    @Resource
    private MemberMapper memberMapper;

    @GetMapping
    @ApiOperation(value = "插入测试")
    public RestResult testMybatisPlus(){
        Member member = new Member();
        member.setMemberId("21786271527");
        member.setNickname("测试1号");
        member.setAddress("湖南郴州");
        member.setTelephone("15899790993");
        memberMapper.insert(member);
        return new RestResult(member);
    }
}
