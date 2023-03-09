package com.suzz.platform;

import com.suzz.platform.constant.SystemProfileEnum;
import com.suzz.platform.util.StringsUtil;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.transaction.annotation.EnableTransactionManagement;

@DubboComponentScan("com.suzz")
@ComponentScan(basePackages = { "com.suzz"})
@EnableTransactionManagement
@SpringBootApplication
public class FacadeApplication {

	private static final String SPRING_PROFILE_KEY =  "spring.profiles.active";

	public static void main(String[] args) {
		chooseProfile();
		SpringApplication.run(FacadeApplication.class, args);
	}

	private static void chooseProfile() {
		String property = System.getProperty(SPRING_PROFILE_KEY);
		if(StringsUtil.isEmpty(property)){
			System.setProperty(SPRING_PROFILE_KEY, SystemProfileEnum.DEV.getValue());
		}
	}
	
}
