package com.yichun.ticket.member.controller;

import com.yichun.ticket.common.context.LoginMemberContext;
import com.yichun.ticket.common.resp.CommonResp;
import com.yichun.ticket.member.req.PassengerQueryReq;
import com.yichun.ticket.member.req.PassengerSaveReq;
import com.yichun.ticket.member.resp.PageResp;
import com.yichun.ticket.member.resp.PassengerQueryResp;
import com.yichun.ticket.member.service.PassengerService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Resource
    private PassengerService passengerService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody PassengerSaveReq req){
        passengerService.save(req);
        return new CommonResp<>();
    }
    @GetMapping("/query-list")
    public CommonResp<PageResp<PassengerQueryResp>> queryList(@Valid PassengerQueryReq req){
        req.setMemberId(LoginMemberContext.getId());
        PageResp<PassengerQueryResp> list = passengerService.queryList(req);
        return new CommonResp<>(list);
    }

}
