package com.yichun.ticket.business.controller;

import com.yichun.ticket.business.resp.TrainQueryResp;
import com.yichun.ticket.business.service.TrainSeatService;
import com.yichun.ticket.business.service.TrainService;
import com.yichun.ticket.common.resp.CommonResp;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Resource
    private TrainService trainService;

    @Resource
    private TrainSeatService trainSeatService;

    @GetMapping("/query-all")
    public CommonResp<List<TrainQueryResp>> queryList() {
        List<TrainQueryResp> list = trainService.queryAll();
        return new CommonResp<>(list);
    }

}