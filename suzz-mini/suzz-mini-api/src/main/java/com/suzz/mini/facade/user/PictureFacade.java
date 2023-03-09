package com.suzz.mini.facade.user;

import com.suzz.mini.dto.PictureDTO;
import com.suzz.mini.dto.PictureQueryDTO;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.SimpleResponse;

/**
 * @author subo
 * @date 2022/8/7 18:45
 **/
public interface PictureFacade {

    SimpleResponse<Integer> insert(SimpleRequest<PictureDTO> request) throws ApplicationException, BusinessException, ProgramException;

    SimpleResponse<PictureDTO> queryPicture(SimpleRequest<PictureQueryDTO> request) throws ApplicationException, BusinessException, ProgramException;

    ResponseDTO deletePicture(SimpleRequest<PictureDTO> request) throws ApplicationException, BusinessException, ProgramException;
}
