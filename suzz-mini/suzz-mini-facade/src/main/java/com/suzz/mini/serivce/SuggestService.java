package com.suzz.mini.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import com.suzz.mini.domain.Suggest;

/**
 * @author subo
 * @date 2022/8/7 18:49
 **/
public interface SuggestService extends IService<Suggest> {

   void submit(Suggest suggest);
}
