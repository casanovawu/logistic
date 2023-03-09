package com.suzz.mini.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.suzz.mini.dto.SuggestSubmitDTO;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author subo
 * @date 2022/8/7 21:19
 **/
@Data
@TableName(value = "suggest")
public class Suggest  {

    @TableId(type= IdType.AUTO)
    private Integer id;

    private Integer type;

    @TableField("fk_mini_user")
    private Integer miniUserId;

    @TableField("fk_mini_user_suggest")
    private Integer miniUserSuggestId;

    @TableField("fk_order")
    private Integer orderId;

    private Integer status;

    private String content;

    @TableField("contact_name")
    private String contactName;

    @TableField("contact_phone")
    private String contactPhone;

    @TableField(exist = false)
    private List<SuggestPictureLink> suggestPictureLinkList;

    public static Suggest toSuggest(SuggestSubmitDTO suggestSubmitDTO){
        Suggest suggest = new Suggest();
        suggest.setType(suggestSubmitDTO.getType());
        suggest.setMiniUserSuggestId(suggestSubmitDTO.getMiniSuggestUserId());
        suggest.setOrderId(suggestSubmitDTO.getOrderId());
        suggest.setContent(suggestSubmitDTO.getContent());
        suggest.setContactName(suggestSubmitDTO.getContactName());
        suggest.setContactPhone(suggestSubmitDTO.getContactPhone());
        if(!CollectionUtils.isEmpty(suggestSubmitDTO.getPictureList())){
            List<SuggestPictureLink> suggestPictureLinkList = suggestSubmitDTO.getPictureList().stream().map(a -> {
                SuggestPictureLink suggestPictureLink = new SuggestPictureLink();
                suggestPictureLink.setPictureId(a);
                return suggestPictureLink;
            }).collect(Collectors.toList());
            suggest.setSuggestPictureLinkList(suggestPictureLinkList);
        }
        return suggest;
    }
}
