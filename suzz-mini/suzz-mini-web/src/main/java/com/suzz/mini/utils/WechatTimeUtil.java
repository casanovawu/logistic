/**
 * 
 */
package com.suzz.mini.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 */
@Slf4j
public class WechatTimeUtil {
	
	/**
     * 将标准格式的当前时间（yyyy-MM-dd HH:mm:ss）转换成微信消息中的CreateTime
     * 
     * @param createTime 消息创建时间
     * @return
     */
    public static long getCurrentSecond() {
    	long mills = System.currentTimeMillis();
    	return mills / 1000;
    }
    
    /**
     * 将微信消息中的CreateTime转换成标准格式的时间对象
     * 
     * @param createTime 消息创建时间
     * @return
     */
    public static Date formatTime(Long createTime) {
    	// 将微信传入的CreateTime转换成long类型，再乘以1000
    	long msgCreateTime = createTime * 1000L;
    	return new Date(msgCreateTime);
    }
    /**
     * 将微信消息中的CreateTime转换成标准格式的时间对象(yyyy-MM-dd HH:mm:ss)
     * 
     * @param createTime 消息创建时间
     * @return
     */
    public static String formatDate(Long createTime) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = formatTime(createTime);
    	return sdf.format(date);
    }
    /**
     * 将标准格式的时间（yyyy-MM-dd HH:mm:ss）转换成微信消息中的CreateTime
     * @param time  时间
     * @param pattern   格式模式字符串
     * @return
     */
    public static long formatStringToTime(String time,String pattern){
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    	Date date = null;
    	try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			log.warn("日期解析失败：" + e.getMessage());
		}
    	if(Objects.nonNull(date)) {
        	return date.getTime() /1000; 
    	}else {
    		return 0L;
    	}
    }

}
