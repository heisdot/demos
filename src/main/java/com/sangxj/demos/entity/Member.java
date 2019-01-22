package com.sangxj.demos.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @描述: 会员
 * @创建人 coinko
 * @创建时间 2019/1/3
 */
@Data
public class Member extends Model<Member> {
    @TableId(value = "member_id")
    private Long memberId;
    private Integer no;
    private Integer groupId;
    private String nickname;
    private String realname;
    private String telephone;
    private String address;
}
