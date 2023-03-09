package com.suzz.mini.serivce.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.WxMaSubscribeService;
import cn.binarywang.wx.miniapp.bean.WxMaSubscribeMessage;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suzz.mini.constant.IsValidEnum;
import com.suzz.mini.constant.LineSubscribeEnum;
import com.suzz.mini.constant.PriceStyleEnum;
import com.suzz.mini.domain.*;
import com.suzz.mini.domain.condition.DictionaryCondition;
import com.suzz.mini.domain.condition.LineSubscribeCondition;
import com.suzz.mini.mapper.LineSubscribeMapper;
import com.suzz.mini.serivce.*;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.lang.Exception;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author subo
 * @date 2022/8/7 18:50
 **/
@Service
public class LineSubscribeServiceImpl extends ServiceImpl<LineSubscribeMapper, LineSubscribe> implements LineSubscribeService {

    @Autowired
    private LineSubscribeCarTypeService lineSubscribeCarTypeService;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private WxMaService wxMaService;

    @Autowired
    private MiniUserService miniUserService;

    @Autowired
    private DictionaryService dictionaryService;

    @Override
    @Transactional
    public void insert(LineSubscribe lineSubscribe) {
        List<LineSubscribe> lineSubscribes = this.baseMapper.selectList(new LambdaQueryWrapper<LineSubscribe>().eq(LineSubscribe::getMiniUserId, lineSubscribe.getMiniUserId()));
        if (lineSubscribes.size() >= 3) {
            throw new ApplicationException("订阅数量超过3个不能新增", "-1");
        }
        this.baseMapper.insert(lineSubscribe);
        if (CollectionUtil.isNotEmpty(lineSubscribe.getCarTypeList())) {
            for (LineSubscribeCarType lineSubscribeCarType : lineSubscribe.getCarTypeList()) {
                lineSubscribeCarType.setLineSubscribeId(lineSubscribe.getId());
                lineSubscribeCarTypeService.getBaseMapper().insert(lineSubscribeCarType);
            }
        }
    }

    @Override
    @Transactional
    public void update(LineSubscribe lineSubscribe) {
        this.baseMapper.updateById(lineSubscribe);
        lineSubscribeCarTypeService.getBaseMapper().delete(new LambdaQueryWrapper<LineSubscribeCarType>().eq(LineSubscribeCarType::getLineSubscribeId, lineSubscribe.getId()));
        if (CollectionUtil.isNotEmpty(lineSubscribe.getCarTypeList())) {
            for (LineSubscribeCarType lineSubscribeCarType : lineSubscribe.getCarTypeList()) {
                lineSubscribeCarType.setLineSubscribeId(lineSubscribe.getId());
                lineSubscribeCarType.setId(null);
                lineSubscribeCarTypeService.getBaseMapper().insert(lineSubscribeCarType);
            }
        }
    }

    @Override
    public List<LineSubscribe> queryList(LineSubscribeCondition condition) {
        List<LineSubscribe> lineSubscribes = this.getBaseMapper().selectList(new LambdaQueryWrapper<LineSubscribe>().eq(LineSubscribe::getMiniUserId, condition.getMiniUserId()).eq(LineSubscribe::getIsValid,IsValidEnum.VALID.getCode()));
        if (CollectionUtil.isNotEmpty(lineSubscribes)) {
            for (LineSubscribe lineSubscribe : lineSubscribes) {
                List<LineSubscribeCarType> lineSubscribeCarTypes = lineSubscribeCarTypeService.getBaseMapper().selectList(new LambdaQueryWrapper<LineSubscribeCarType>().eq(LineSubscribeCarType::getLineSubscribeId, lineSubscribe.getId()));
                lineSubscribe.setCarTypeList(lineSubscribeCarTypes);
                String departureName = provinceService.queryNameByCode(lineSubscribe.getDepartureAreaCode());
                String arriveName = provinceService.queryNameByCode(lineSubscribe.getArriveAreaCode());
                lineSubscribe.setArriveName(arriveName);
                lineSubscribe.setDepartureName(departureName);
            }
        }
        return lineSubscribes;
    }

    @Override
    public LineSubscribe queryOne(LineSubscribeCondition condition) {
        LineSubscribe lineSubscribe = this.getBaseMapper().selectById(condition.getId());
        if (Objects.nonNull(lineSubscribe)) {
            List<LineSubscribeCarType> lineSubscribeCarTypes = lineSubscribeCarTypeService.getBaseMapper().selectList(new LambdaQueryWrapper<LineSubscribeCarType>().eq(LineSubscribeCarType::getLineSubscribeId, lineSubscribe.getId()));
            lineSubscribe.setCarTypeList(lineSubscribeCarTypes);
            String departureName = provinceService.queryNameByCode(lineSubscribe.getDepartureAreaCode());
            String arriveName = provinceService.queryNameByCode(lineSubscribe.getArriveAreaCode());
            lineSubscribe.setArriveName(arriveName);
            lineSubscribe.setDepartureName(departureName);
        }
        return lineSubscribe;
    }

    @Override
    public void sendSubscribeMessage(LineSubscribeCondition condition) {
        List<LineSubscribe> lineSubscribeList = queryUserIdListByLineSubscribe(condition);
        if(CollectionUtil.isNotEmpty(lineSubscribeList)){
            for (LineSubscribe lineSubscribe : lineSubscribeList) {
                MiniUser miniUser = miniUserService.selectByPrimaryKey(lineSubscribe.getMiniUserId());
                try {
                    String departureAreaName = provinceService.queryNameByCode(condition.getDepartureAreaCode());
                    String arriveAreaName = provinceService.queryNameByCode(condition.getArriveAreaCode());
                    StringBuilder CarTypeListString = new StringBuilder();
                    if(CollectionUtil.isNotEmpty(condition.getCarTypeList())){
                        DictionaryCondition dictionaryCondition=new DictionaryCondition();
                        dictionaryCondition.setLang(miniUser.getLanguage());
                        dictionaryCondition.setCode("car_type");

                        for (Integer integer : condition.getCarTypeList()) {
                            List<Dictionary> dictionaries = dictionaryService.queryList(dictionaryCondition);
                            Map<Integer, List<Dictionary>> map = dictionaries.stream().collect(Collectors.groupingBy(Dictionary::getKey));
                            List<Dictionary> dictionaries1 = map.get(integer);
                            if(CollectionUtil.isNotEmpty(dictionaries1)){
                                Dictionary dictionary = dictionaries1.get(0);
                                CarTypeListString.append(dictionary.getDictionaryLang().getName());
                            }
                        }
                    }
                    WxMaSubscribeMessage wxMaSubscribeMessage=new WxMaSubscribeMessage();
                    wxMaSubscribeMessage.setToUser(miniUser.getOpenId());
                    wxMaSubscribeMessage.setTemplateId(LineSubscribeEnum.LineSubscribeTemplateEnum.LONG_MESSAGE.getCode());
                    WxMaSubscribeMessage.MsgData msgData = new WxMaSubscribeMessage.MsgData();
                    msgData.setName("thing2");
                    msgData.setValue(departureAreaName+"—>"+arriveAreaName);
                    wxMaSubscribeMessage.addData(msgData);

                    WxMaSubscribeMessage.MsgData msgData1 = new WxMaSubscribeMessage.MsgData();
                    msgData1.setName("time3");
                    msgData1.setValue(DateUtil.get4yMd(condition.getUseStartDate()));
                    wxMaSubscribeMessage.addData(msgData1);

                    WxMaSubscribeMessage.MsgData msgData2 = new WxMaSubscribeMessage.MsgData();
                    msgData2.setName("thing5");
                    StringBuilder sb=new StringBuilder();
                    sb.append("车辆类型:").append(CarTypeListString.toString()).append("价格:");
                    if(PriceStyleEnum.PRICE.getCode().equals(condition.getPriceStyle())){
                        if(Objects.nonNull(condition.getPrice())){
                            sb.append(condition.getPrice().toString()).append("元");
                        }
                    }
                    if(PriceStyleEnum.PHONE.getCode().equals(condition.getPriceStyle())){
                        sb.append(PriceStyleEnum.PHONE.getValue());
                    }
                    msgData2.setValue(sb.toString());
                    wxMaSubscribeMessage.addData(msgData2);

                    WxMaSubscribeService subscribeService = wxMaService.getSubscribeService();
                    subscribeService.sendSubscribeMsg(wxMaSubscribeMessage);

                    lineSubscribe.setSend(LineSubscribeEnum.LineSubscribeSendEnum.SENDED.getCode());
                    lineSubscribe.setIsValid(IsValidEnum.NOT_VALID.getCode());
                }catch (Exception e){
                    log.error(e.getMessage(),e);
                }
            }

        }
    }

    private List<LineSubscribe> queryUserIdListByLineSubscribe(LineSubscribeCondition condition) {
        List<LineSubscribe> lineSubscribeList=new ArrayList<>();
        List<LineSubscribe> lineSubscribes = this.getBaseMapper().selectList(new LambdaQueryWrapper<LineSubscribe>()
                .eq(LineSubscribe::getDepartureAreaCode, condition.getDepartureAreaCode())
                .eq(!StringUtils.isEmpty(condition.getArriveAreaCode()), LineSubscribe::getArriveAreaCode, condition.getArriveAreaCode())
                .eq(LineSubscribe::getSend, LineSubscribeEnum.LineSubscribeSendEnum.UNSEND.getCode())
                .eq(LineSubscribe::getIsValid,IsValidEnum.VALID.getCode()));
        if(CollectionUtil.isNotEmpty(lineSubscribes)){
            for (LineSubscribe lineSubscribe : lineSubscribes) {
                List<LineSubscribeCarType> lineSubscribeCarTypes = lineSubscribeCarTypeService.getBaseMapper().selectList(new LambdaQueryWrapper<LineSubscribeCarType>().eq(LineSubscribeCarType::getLineSubscribeId, lineSubscribe.getId()));
                if(CollectionUtil.isNotEmpty(lineSubscribeCarTypes) && CollectionUtil.isNotEmpty(condition.getCarTypeList())){
                    List<Integer> lineSubscribeCarTypeList = lineSubscribeCarTypes.stream().map(LineSubscribeCarType::getCarType).collect(Collectors.toList());
                    boolean exist = lineSubscribeCarTypeList.stream().anyMatch(a -> condition.getCarTypeList().contains(a));
                    if(exist){
                        lineSubscribeList.add(lineSubscribe);
                    }
                }else {
                    lineSubscribeList.add(lineSubscribe);
                }
            }
        }
        return lineSubscribeList;
    }

    @Override
    @Transactional
    public void delete(LineSubscribe lineSubscribe) {
        if (Objects.nonNull(lineSubscribe.getId())) {
            this.getBaseMapper().deleteById(lineSubscribe.getId());
            lineSubscribeCarTypeService.getBaseMapper().delete(new LambdaQueryWrapper<LineSubscribeCarType>().eq(LineSubscribeCarType::getLineSubscribeId, lineSubscribe.getId()));
        }
    }
}
