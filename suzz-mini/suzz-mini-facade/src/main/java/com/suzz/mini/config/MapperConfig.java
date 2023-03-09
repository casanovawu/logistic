package com.suzz.mini.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author subo
 * @date 2022/5/2 18:41
 **/
@MapperScan("com.suzz.mini.mapper")
@Component
public class MapperConfig {
}
