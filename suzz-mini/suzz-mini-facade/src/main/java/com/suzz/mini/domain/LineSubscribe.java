package com.suzz.mini.domain;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.suzz.mini.dto.driven.LineSubscribeCreateDTO;
import com.suzz.mini.dto.driven.LineSubscribeDeleteDTO;
import com.suzz.mini.dto.driven.LineSubscribeQueryInfoDTO;
import com.suzz.mini.dto.driven.LineSubscribeUpdateDTO;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author subo
 * @date 2022-08-09 13:16
 **/
@Data
@TableName("line_subscribe")
public class LineSubscribe{

    @TableId(type= IdType.AUTO)
    private Integer id;

    @TableField("fk_mini_user")
    private Integer miniUserId;

    @TableField("departure_area_code")
    private String departureAreaCode;

    @TableField("arrive_area_code")
    private String arriveAreaCode;

    @TableField("send")
    private Integer send;

    @TableField(exist = false)
    private String departureName;

    @TableField(exist = false)
    private String arriveName;

    @TableField(exist = false)
    private List<LineSubscribeCarType> carTypeList;

    @TableField("is_valid")
    private Integer isValid;

    public static LineSubscribe toCreateLineSubscribe(LineSubscribeCreateDTO lineSubscribeCreateDTO){
        LineSubscribe lineSubscribe = new LineSubscribe();
        lineSubscribe.setMiniUserId(lineSubscribeCreateDTO.getMiniUserId());
        lineSubscribe.setDepartureAreaCode(lineSubscribeCreateDTO.getDepartureAreaCode());
        lineSubscribe.setArriveAreaCode(lineSubscribeCreateDTO.getArriveAreaCode());
        if(CollectionUtil.isNotEmpty(lineSubscribeCreateDTO.getCartTypeList())){
            List<LineSubscribeCarType> lineSubscribeCarTypes = lineSubscribeCreateDTO.getCartTypeList().stream().map(a -> {
                LineSubscribeCarType lineSubscribeCarType = new LineSubscribeCarType();
                lineSubscribeCarType.setCarType(a);
                return lineSubscribeCarType;
            }).collect(Collectors.toList());
            lineSubscribe.setCarTypeList(lineSubscribeCarTypes);
        }
        return lineSubscribe;
    }

    public static LineSubscribe toUpdateLineSubscribe(LineSubscribeUpdateDTO lineSubscribeUpdateDTO){
        LineSubscribe lineSubscribe = new LineSubscribe();
        lineSubscribe.setId(lineSubscribeUpdateDTO.getId());
        lineSubscribe.setDepartureAreaCode(lineSubscribeUpdateDTO.getDepartureAreaCode());
        lineSubscribe.setArriveAreaCode(lineSubscribeUpdateDTO.getArriveAreaCode());
        if(CollectionUtil.isNotEmpty(lineSubscribeUpdateDTO.getCartTypeList())){
            List<LineSubscribeCarType> lineSubscribeCarTypes = lineSubscribeUpdateDTO.getCartTypeList().stream().map(a -> {
                LineSubscribeCarType lineSubscribeCarType = new LineSubscribeCarType();
                lineSubscribeCarType.setCarType(a);
                return lineSubscribeCarType;
            }).collect(Collectors.toList());
            lineSubscribe.setCarTypeList(lineSubscribeCarTypes);
        }
        return lineSubscribe;
    }

    public LineSubscribeQueryInfoDTO toLineSubscribeQueryInfoDTO(){
        LineSubscribeQueryInfoDTO lineSubscribeQueryInfoDTO=new LineSubscribeQueryInfoDTO();
        if(CollectionUtil.isNotEmpty(this.carTypeList)){
            List<Integer> cartTypeList = this.carTypeList.stream().map(LineSubscribeCarType::getCarType).collect(Collectors.toList());
            lineSubscribeQueryInfoDTO.setCartTypeList(cartTypeList);
        }
        lineSubscribeQueryInfoDTO.setArriveAreaCode(this.arriveAreaCode);
        lineSubscribeQueryInfoDTO.setDepartureAreaCode(this.departureAreaCode);
        lineSubscribeQueryInfoDTO.setArriveName(this.arriveName);
        lineSubscribeQueryInfoDTO.setDepartureName(this.departureName);
        lineSubscribeQueryInfoDTO.setId(this.id);
        return lineSubscribeQueryInfoDTO;
    }

    public static LineSubscribe toLineSubscribe(LineSubscribeDeleteDTO lineSubscribeDeleteDTO){
        LineSubscribe lineSubscribe = new LineSubscribe();
        lineSubscribe.setId(lineSubscribeDeleteDTO.getId());
        return lineSubscribe;
    }
}
