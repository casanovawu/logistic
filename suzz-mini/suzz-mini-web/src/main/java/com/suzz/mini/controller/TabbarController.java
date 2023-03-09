package com.suzz.mini.controller;

import com.suzz.mini.constant.LangEnum;
import com.suzz.mini.constant.MiniUserTypeEnum;
import com.suzz.mini.vo.TabbarQueryVO;
import com.suzz.mini.vo.TabbarResultVO;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author subo
 * @date 2022/5/21 22:11
 **/
@Api(tags = "小程序用户")
@RestController
@RequestMapping(path = "/tabbar")
public class TabbarController {

    @PostMapping(path = "/queryList")
    @ApiOperation(value = "查询列表")
    @ResponseBody
    public ListResponse<TabbarResultVO> queryList(@RequestBody @Valid SimpleRequest<TabbarQueryVO> request) {
        TabbarQueryVO reqDtos = request.getReqDtos();
        ListResponse<TabbarResultVO> listRespons=new ListResponse<>();
        List<TabbarResultVO> list=new ArrayList<>();
        listRespons.setData(list);
        if(MiniUserTypeEnum.DRIVEN.getCode().equals(reqDtos.getMiniUserType())){
            if(LangEnum.CHINESE.getCode().equals(reqDtos.getLang())){
                list.add(new TabbarResultVO("/pages/driven/index/index","首页","/common/tabbarImg/index.png","/common/tabbarImg/index-active.png"));
                list.add(new TabbarResultVO("/pages/driven/line/index/index","订阅线路","/common/tabbarImg/subscribe.png","/common/tabbarImg/subscribe-active.png"));
                list.add(new TabbarResultVO("/pages/user/index/index","我的","/common/tabbarImg/user.png","/common/tabbarImg/user-active.png"));
            }
        }
        if(MiniUserTypeEnum.GOODS_OWNER.getCode().equals(reqDtos.getMiniUserType())){
            if(LangEnum.CHINESE.getCode().equals(reqDtos.getLang())){
                list.add(new TabbarResultVO("/pages/goods_owner/index/index","首页","/common/tabbarImg/index.png","/common/tabbarImg/index-active.png"));
                list.add(new TabbarResultVO("/pages/goods_owner/publish/index","发布","/common/tabbarImg/publish.png","/common/tabbarImg/publish-active.png"));
                list.add(new TabbarResultVO("/pages/user/index/index","我的","/common/tabbarImg/user.png","/common/tabbarImg/user-active.png"));
            }
        }
        return listRespons;
    }
}
