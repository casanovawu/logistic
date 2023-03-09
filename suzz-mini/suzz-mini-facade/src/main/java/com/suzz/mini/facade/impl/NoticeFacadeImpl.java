package com.suzz.mini.facade.impl;

import com.suzz.mini.domain.Notice;
import com.suzz.mini.facade.NoticeFacade;
import com.suzz.mini.serivce.NoticeService;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author subo
 * @date 2022/10/1 16:22
 **/
@DubboService(interfaceClass = NoticeFacade.class)
@Api(tags = "noticeFacadeImpl")
public class NoticeFacadeImpl implements NoticeFacade {

    @Autowired
    private NoticeService noticeService;

    @Override
    public SimpleResponse<String> query() throws ApplicationException, BusinessException, ProgramException {
        Notice notice = noticeService.query().orderByDesc("id").last("limit 1").one();
        return new SimpleResponse<>(notice.getContent());
    }
}
