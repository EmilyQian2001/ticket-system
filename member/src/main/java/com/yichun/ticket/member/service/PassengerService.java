package com.yichun.ticket.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.yichun.ticket.common.context.LoginMemberContext;
import com.yichun.ticket.common.util.SnowUtil;
import com.yichun.ticket.member.domain.Passenger;
import com.yichun.ticket.member.domain.PassengerExample;
import com.yichun.ticket.member.mapper.PassengerMapper;
import com.yichun.ticket.member.req.PassengerQueryReq;
import com.yichun.ticket.member.req.PassengerSaveReq;
import com.yichun.ticket.member.resp.PassengerQueryResp;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Resource
    private PassengerMapper passengerMapper;

    //新增乘客信息
    public void save(PassengerSaveReq req){
        DateTime now = DateTime.now();
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        passenger.setId(SnowUtil.getSnowflakeNextId());
        passenger.setMemberId(LoginMemberContext.getId());
        passenger.setCreateTime(now);
        passenger.setUpdateTime(now);
        passengerMapper.insert(passenger);
    }

    public List<PassengerQueryResp> queryList(PassengerQueryReq req){
        PassengerExample passengerExample = new PassengerExample();
        PassengerExample.Criteria criteria= passengerExample.createCriteria();
        //必须把criteria放在外面，这样可以叠加多个条件
        if(ObjectUtil.isNotNull(req.getMemberId())){
            criteria.andMemberIdEqualTo(req.getMemberId());
        }
        List<Passenger> passengerList = passengerMapper.selectByExample(passengerExample);
        return BeanUtil.copyToList(passengerList, PassengerQueryResp.class);
    }
}
