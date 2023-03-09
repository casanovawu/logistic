package com.suzz.mini.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suzz.mini.domain.Agreement;
import com.suzz.mini.mapper.AgreementMapper;
import com.suzz.mini.serivce.AgreementService;
import org.springframework.stereotype.Service;

/**
 * @author subo
 * @date 2023/1/4 21:27
 **/
@Service
public class AgreementServiceImpl extends ServiceImpl<AgreementMapper, Agreement>  implements AgreementService {

}
