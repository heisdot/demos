package com.sangxj.demos.controller;

import com.sangxj.demos.vo.RestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述:
 * @创建人 coinko
 * @创建时间 2019/1/3
 */
@RestController
@RequestMapping(value = "/hello", produces = "application/json;charset=utf-8")
@Api("Hello")
public class Hello {
    @GetMapping
    @ApiOperation(value = "查询测试", notes = "查询测试1")
    public RestResult Hello(){
        return new RestResult("hello");
    }
}
