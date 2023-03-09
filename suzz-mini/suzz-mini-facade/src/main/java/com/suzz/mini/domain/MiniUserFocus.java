package com.suzz.mini.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.suzz.mini.dto.driven.MiniUserFocusUpdateDTO;
import lombok.Data;

/**
 * @author subo
 * @date 2022/7/31 10:52
 **/
@Data
@TableName(value = "mini_user_focus")
public class MiniUserFocus  {

    @TableId(type=IdType.AUTO)
    private Integer id;

    @TableField("fk_mini_user")
    private Integer miniUserId;

    @TableField("fk_mini_user_focus")
    private Integer miniUserFocusId;

    /**
     * 数据有效状态
     * 对应表中的 isValid 字段
     */
    @TableLogic(value = "1",delval = "0")
    private Boolean isValid;

    @TableField(exist = false)
    private Integer isFocus;

    public static MiniUserFocus toMiniUserFocus(MiniUserFocusUpdateDTO miniUserFocusUpdateDTO){
        MiniUserFocus miniUserFocus = new MiniUserFocus();
        miniUserFocus.setMiniUserId(miniUserFocusUpdateDTO.getMiniUserId());
        miniUserFocus.setMiniUserFocusId(miniUserFocusUpdateDTO.getMiniUserFocusId());
        miniUserFocus.setIsFocus(miniUserFocusUpdateDTO.getIsFocus());
        return miniUserFocus;

    }

}
