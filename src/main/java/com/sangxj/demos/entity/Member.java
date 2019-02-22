package com.sangxj.demos.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;


@Data
public class Member extends Model<Member> {
    @TableId(value = "member_id")
    private Long memberId;
    private Integer memberNo;
    private String nick;
    private String name;
    private String telephone;
    private String address;
}