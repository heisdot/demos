package com.sangxj.demos.controller;

import com.sangxj.demos.vo.RestResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述:
 * @创建人 coinko
 * @创建时间 2019/1/3
 */
@RestController
public class Hello {
    @GetMapping
    public RestResult Hello(){
        return new RestResult("hello");
    }
}
