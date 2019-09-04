package com.powerchen.springcloud.member.repository;

import com.powerchen.springcloud.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: powerchen
 * @Date: 2019/9/3 17:19
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
    // 根据手机号查询所有的会员信息
    List<Member> findByMobile(String mobile);
}
