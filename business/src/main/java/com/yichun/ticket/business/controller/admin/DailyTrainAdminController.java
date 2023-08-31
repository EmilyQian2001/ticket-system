package com.yichun.ticket.business.controller.admin;

import com.yichun.ticket.common.context.LoginMemberContext;
import com.yichun.ticket.common.resp.CommonResp;
import com.yichun.ticket.common.resp.PageResp;
import com.yichun.ticket.business.req.DailyTrainQueryReq;
import com.yichun.ticket.business.req.DailyTrainSaveReq;
import com.yichun.ticket.business.resp.DailyTrainQueryResp;
import com.yichun.ticket.business.service.DailyTrainService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train")
public class DailyTrainAdminController {

    @Resource
    private DailyTrainService dailyTrainService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody DailyTrainSaveReq req) {
        dailyTrainService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainQueryResp>> queryList(@Valid DailyTrainQueryReq req) {
        PageResp<DailyTrainQueryResp> list = dailyTrainService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        dailyTrainService.delete(id);
        return new CommonResp<>();
    }

}