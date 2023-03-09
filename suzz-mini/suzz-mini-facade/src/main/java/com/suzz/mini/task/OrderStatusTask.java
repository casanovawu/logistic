package com.suzz.mini.task;

import com.suzz.mini.serivce.MiniOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author subo
 * @date 2022/8/13 10:00
 **/
@Component
@Slf4j
@Profile(value ="prd")
public class OrderStatusTask {

    @Autowired
    private MiniOrderService miniOrderService;

    /**
     * 修改发布时间超过5天的
     */
    @Scheduled(cron = "0/1 * * * * ? ")
    public void updateStatusMoreThanFiveDay(){
        miniOrderService.updateStatusMoreThanFiveDay();
    }
}