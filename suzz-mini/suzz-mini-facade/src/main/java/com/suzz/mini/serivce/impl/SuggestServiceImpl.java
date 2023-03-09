package com.suzz.mini.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suzz.mini.constant.SuggestEnum;
import com.suzz.mini.domain.Order;
import com.suzz.mini.domain.Suggest;
import com.suzz.mini.domain.SuggestPictureLink;
import com.suzz.mini.mapper.SuggestMapper;
import com.suzz.mini.serivce.MiniOrderService;
import com.suzz.mini.serivce.SuggestPictureLinkService;
import com.suzz.mini.serivce.SuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Objects;

/**
 * @author subo
 * @date 2022/8/7 18:50
 **/
@Service
public class SuggestServiceImpl extends ServiceImpl<SuggestMapper, Suggest> implements SuggestService {

    @Autowired
    private MiniOrderService miniOrderService;

    @Autowired
    private SuggestPictureLinkService suggestPictureLinkService;

    @Override
    @Transactional
    public void submit(Suggest suggest) {
        suggest.setStatus(SuggestEnum.DEALING.getCode());
        if(Objects.nonNull(suggest.getOrderId())){
            Order order = miniOrderService.selectOrderById(suggest.getOrderId());
            suggest.setMiniUserId(order.getFkMiniUser());
        }
        this.baseMapper.insert(suggest);
        if(!CollectionUtils.isEmpty(suggest.getSuggestPictureLinkList())){
            for (SuggestPictureLink suggestPictureLink : suggest.getSuggestPictureLinkList()) {
                suggestPictureLink.setSuggestId(suggest.getId());
                suggestPictureLinkService.save(suggestPictureLink);
            }
        }
    }
}
