package com.suzz.mini.domain.condition;


import com.suzz.mini.dto.PictureQueryDTO;
import lombok.Data;

/**
 * @author subo
 * @date 2022/8/7 18:42
 **/
@Data
public class PictureCondition {

    private Integer id;

    private Integer miniUserId;

    private String md5;

    public static PictureCondition toPictureCondition(PictureQueryDTO pictureQueryDTO){
        PictureCondition pictureCondition = new PictureCondition();
        pictureCondition.setMiniUserId(pictureQueryDTO.getMiniUserId());
        pictureCondition.setMd5(pictureQueryDTO.getMd5());
        pictureCondition.setId(pictureQueryDTO.getId());
        return pictureCondition;
    }

}
