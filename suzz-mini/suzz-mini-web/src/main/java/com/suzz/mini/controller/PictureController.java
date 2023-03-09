package com.suzz.mini.controller;

import cn.hutool.core.io.FastByteArrayOutputStream;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.crypto.SecureUtil;
import com.suzz.mini.dto.PictureDTO;
import com.suzz.mini.dto.PictureQueryDTO;
import com.suzz.mini.facade.user.PictureFacade;
import com.suzz.mini.vo.PictureDeleteVO;
import com.suzz.mini.vo.PictureVO;
import com.suzz.platform.constant.DubboReferenceFacade;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.util.Objects;
import java.util.UUID;

/**
 * @author subo
 * @date 2022/8/7 17:05
 **/
@Api(tags = "图片")
@RestController
@RequestMapping(path = "/picture")
@Slf4j
public class PictureController {

    @Value("${spring.servlet.multipart.location}")
    private String location;

    @DubboReference(timeout = DubboReferenceFacade.TIMEOUT, lazy = DubboReferenceFacade.LAZY, retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
    private PictureFacade pictureFacade;

    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    @ApiOperation(value = "图片上传")
    @ResponseBody
    public SimpleResponse<PictureVO> upload(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file) {
        try {
            Integer miniUserId = Integer.valueOf(request.getParameter("miniUserId"));
            String md5 = SecureUtil.md5(file.getInputStream());
            PictureQueryDTO pictureQueryDTO = getPictureQueryDTO(miniUserId, md5);
            SimpleResponse<PictureDTO> simpleResponse = pictureFacade.queryPicture(new SimpleRequest<>(pictureQueryDTO));
            String originalFilename = file.getOriginalFilename();
            if (Objects.nonNull(simpleResponse.getData())) {
                PictureVO pictureVO = getPictureVO(miniUserId, md5, originalFilename, simpleResponse.getData().getId());
                return new SimpleResponse<>(pictureVO);
            }
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            //图片文件地址
            String path = location + File.separator + "suggest" + File.separator + UUID.randomUUID().toString() + suffixName;
            File newFile = new File(path);
            if (!newFile.exists()) {
                newFile.mkdirs();
            }
            file.transferTo(newFile);
            PictureDTO pictureDTO = getPictureDTO(miniUserId, md5, originalFilename, path);
            SimpleResponse<Integer> insert = pictureFacade.insert(new SimpleRequest<>(pictureDTO));
            PictureVO pictureVO = getPictureVO(miniUserId, md5, originalFilename, insert.getData());
            return new SimpleResponse<>(pictureVO);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ApplicationException("图片上传错误", "-1");
        }
    }

    @RequestMapping(value = "/uploadHead", method = {RequestMethod.POST})
    @ApiOperation(value = "图片上传")
    @ResponseBody
    public SimpleResponse<String> uploadHead(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            //图片文件地址
            String path = location + File.separator + "head" + File.separator + UUID.randomUUID().toString() + suffixName;
            File newFile = new File(path);
            if (!newFile.exists()) {
                newFile.mkdirs();
            }
            file.transferTo(newFile);
            return new SimpleResponse<>(path);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ApplicationException("图片上传错误", "-1");
        }
    }

    private PictureDTO getPictureDTO(Integer miniUserId, String md5, String originalFilename, String path) {
        PictureDTO pictureDTO = new PictureDTO();
        pictureDTO.setUrl(path);
        pictureDTO.setMd5(md5);
        pictureDTO.setMiniUserId(miniUserId);
        pictureDTO.setName(originalFilename);
        return pictureDTO;
    }

    private PictureVO getPictureVO(Integer miniUserId, String md5, String originalFilename, Integer id) {
        PictureVO pictureVO = new PictureVO();
        pictureVO.setUrl("http://xxx.xxx.xxx/mini/web/picture/query?md5=" + md5 + "&miniUserId=" + miniUserId);
        pictureVO.setId(id);
        pictureVO.setName(originalFilename);
        return pictureVO;
    }

    private PictureQueryDTO getPictureQueryDTO(Integer miniUserId, String md5) {
        PictureQueryDTO pictureQueryDTO = new PictureQueryDTO();
        pictureQueryDTO.setMd5(md5);
        pictureQueryDTO.setMiniUserId(miniUserId);
        return pictureQueryDTO;
    }

    @RequestMapping(value = "/query", method = {RequestMethod.GET})
    @ApiOperation(value = "图片查询")
    public ResponseEntity<byte[]> query(String md5, Integer miniUserId) {
        PictureQueryDTO pictureQueryDTO = getPictureQueryDTO(miniUserId, md5);
        SimpleResponse<PictureDTO> simpleResponse = pictureFacade.queryPicture(new SimpleRequest<>(pictureQueryDTO));
        if(Objects.nonNull(simpleResponse)){
            PictureDTO data = simpleResponse.getData();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            String fileName = data.getName();
            headers.setContentDispositionFormData("attachment", fileName);
            File file=new File(data.getUrl());
            FastByteArrayOutputStream read = IoUtil.read(FileUtil.getInputStream(file));
            read.close();
            return new ResponseEntity<>(read.toByteArray(), headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/queryHead", method = {RequestMethod.GET})
    @ApiOperation(value = "图片查询")
    public ResponseEntity<byte[]> queryHead(String path) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        String fileName = "head.jpg";
        headers.setContentDispositionFormData("attachment", fileName);
        File file=new File(path);
        FastByteArrayOutputStream read = IoUtil.read(FileUtil.getInputStream(file));
        read.close();
        return new ResponseEntity<>(read.toByteArray(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    @ApiOperation(value = "图片删除")
    @ResponseBody
    public ResponseDTO delete(@RequestBody @Valid SimpleRequest<PictureDeleteVO> request) {
        if(Objects.nonNull(request.getReqDtos().getId())){
            PictureQueryDTO pictureQueryDTO = new PictureQueryDTO();
            pictureQueryDTO.setId(request.getReqDtos().getId());
            SimpleResponse<PictureDTO> simpleResponse = pictureFacade.queryPicture(new SimpleRequest<>(pictureQueryDTO));
            if(Objects.nonNull(simpleResponse)){
                PictureDTO pictureDTO=new PictureDTO();
                pictureDTO.setId(request.getReqDtos().getId());
                pictureFacade.deletePicture(new SimpleRequest<>(pictureDTO));
                PictureDTO data = simpleResponse.getData();
                File file=new File(data.getUrl());
                file.delete();
            }
        }
        return new ResponseDTO();
    }
}
