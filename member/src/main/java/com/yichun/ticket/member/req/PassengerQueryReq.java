package com.yichun.ticket.member.req;

import com.yichun.ticket.common.req.PageReq;

public class PassengerQueryReq extends PageReq {

    private Long memberId;

    public PassengerQueryReq() {
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PassengerQueryReq{");
        sb.append("memberId=").append(memberId);
        sb.append('}');
        return sb.toString();
    }
}