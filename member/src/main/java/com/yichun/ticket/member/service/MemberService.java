package com.yichun.ticket.member.service;

import cn.hutool.core.collection.CollUtil;
import com.yichun.ticket.common.exception.BusinessException;
import com.yichun.ticket.common.exception.BusinessExceptionEnum;
import com.yichun.ticket.member.domain.Member;
import com.yichun.ticket.member.domain.MemberExample;
import com.yichun.ticket.member.mapper.MemberMapper;
import com.yichun.ticket.member.req.MemberRegisterReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    public int count(){
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    public long register(MemberRegisterReq req){
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);

        if (CollUtil.isNotEmpty(list)){
//            return list.get(0).getId(); //已有的话直接给他登录了？
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }
        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
}
