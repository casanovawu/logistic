package com.suzz.mini.facade;

import com.suzz.mini.dto.AgreementDTO;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.SimpleResponse;

/**
 * @author subo
 * @date 2023/1/4 21:29
 **/
public interface AgreementFacade {

    SimpleResponse<AgreementDTO> queryInfo(SimpleRequest<Integer> simpleRequest);
}
