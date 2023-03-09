package com.suzz.mini.facade.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.suzz.mini.domain.Picture;
import com.suzz.mini.domain.condition.PictureCondition;
import com.suzz.mini.dto.PictureDTO;
import com.suzz.mini.dto.PictureQueryDTO;
import com.suzz.mini.facade.user.PictureFacade;
import com.suzz.mini.serivce.PictureService;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.util.FacadeConvertUtil;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @author subo
 * @date 2022/8/7 18:46
 **/
@DubboService(interfaceClass = PictureFacade.class)
@Api(tags = "pictureFacadeImpl")
public class PictureFacadeImpl implements PictureFacade {

    @Autowired
    private PictureService pictureService;

    @Override
    public SimpleResponse<Integer> insert(SimpleRequest<PictureDTO> request) {
        Picture picture = Picture.toPicture(request.getReqDtos());
        pictureService.getBaseMapper().insert(picture);
        return new SimpleResponse<>(picture.getId());
    }

    @Override
    public SimpleResponse<PictureDTO> queryPicture(SimpleRequest<PictureQueryDTO> request) {
        PictureCondition pictureCondition = PictureCondition.toPictureCondition(request.getReqDtos());
        Picture picture = pictureService.getBaseMapper().selectOne(new LambdaQueryWrapper<Picture>()
                .eq(Picture::getMd5, pictureCondition.getMd5())
                .eq(Objects.nonNull(pictureCondition.getMiniUserId()),Picture::getMiniUserId, pictureCondition.getMiniUserId())
                .eq(Objects.nonNull(pictureCondition.getId()),Picture::getId, pictureCondition.getId())
              );
        return FacadeConvertUtil.success(picture,Picture::toPictureDTO);
    }

    @Override
    public ResponseDTO deletePicture(SimpleRequest<PictureDTO> request) {
        Picture picture = Picture.toPicture(request.getReqDtos());
        pictureService.getBaseMapper().deleteById(picture.getId());
        return new ResponseDTO();
    }
}
