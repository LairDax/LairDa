package com.example.springboot2demo.common.exeirtorCommon.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author xnd
 * @since 2023/2/26 9:13
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createBy", String.class,"LairDa");
        this.strictInsertFill(metaObject, "createOn", LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "updateBy", String.class,"LairDa");
        this.strictUpdateFill(metaObject, "updateOn", LocalDateTime.class, LocalDateTime.now());
    }
}
