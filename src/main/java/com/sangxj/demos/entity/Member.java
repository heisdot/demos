package com.sangxj.demos.entity;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @描述: 会员
 * @创建人 coinko
 * @创建时间 2019/1/3
 */
public class Member {
    @TableId(value = "member_id")
    private String memberId;
    private String no;
    private String nickname;
    private String realname;
    private String telephone;
    private String address;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
