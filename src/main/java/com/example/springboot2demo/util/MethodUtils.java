package com.example.springboot2demo.util;

import common.enums.Constants;
import model.base.BaseEntity;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author xnd
 * @since 2023/2/26 9:34
 */
public class MethodUtils {
    public static String userId = null;
    public static String userName = null;
    public static void packageBaseInfoList(List listEntity, Boolean isInsert) {
        {
            listEntity.forEach(item -> {
                packageBaseInfo(item, isInsert);
            });
        }
    }

    /**
     * 包装基本信息
     * @param obj
     * @param isInsert
     */
    private static void packageBaseInfo(Object obj, Boolean isInsert) {
        try{
            userId = HttpUtils.getRequestHeaderInfo(Constants.USER_ID);
            userName = HttpUtils.getRequestHeaderInfo(Constants.USER_NAME);
            userId = (userId == null || "".equals(userId)) ? Constants.DEFAULT_USER_ID : userId;
            userName = (userName == null || "".equals(userName)) ? Constants.DEFAULT_USER_ID : userId;
        }catch (Exception e){
            userId = Constants.DEFAULT_USER_ID;
            userName = "";
        }
        BaseEntity baseEntity =new BaseEntity();
        if(isInsert)
        {
            baseEntity.setCreateOn(LocalDateTime.now());
            baseEntity.setCreateBy(userName);
        }
        baseEntity.setUpdateBy(userName);
        baseEntity.setUpdateOn(LocalDateTime.now());
        BeanUtils.copyProperties(baseEntity,obj);
    }
}
