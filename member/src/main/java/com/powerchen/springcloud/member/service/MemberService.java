package com.powerchen.springcloud.member.service;

import com.powerchen.springcloud.member.entity.Member;
import com.powerchen.springcloud.member.repository.MemberRepository;
import com.powerchen.springcloud.member.service.exception.MemberNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: powerchen
 * @Date: 2019/9/3 17:42
 */
@Service
public class MemberService {
    @Resource
    private MemberRepository memberRepository;

    public Member checkByMobile(String mobile) throws MemberNotFoundException {
        List<Member> members = memberRepository.findByMobile(mobile);
        if (members.size() == 0) {
            throw new MemberNotFoundException("member not found!");
        }
        return members.get(0);
    }
}
