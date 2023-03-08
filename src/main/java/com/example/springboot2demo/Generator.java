package com.example.springboot2demo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import config.BaseEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xnd
 * @since 2023/2/18 13:59
 */
public class Generator {
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG =new DataSourceConfig.Builder(
            "jdbc:mysql://127.0.0.1:3307/khby",
            "root",
            "123456"
    );

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .globalConfig(builder -> builder
                        .author("xnd")
                        .enableSwagger()
                        .disableOpenDir()
                        .outputDir(projectPath  + "/src/main/java"))
                .packageConfig(builder ->builder.parent("com.example.springboot2demo")
                        .entity("entity")
                        .service("service")
                        .serviceImpl("service.impl")
                        .mapper("mapper")
                        .xml("mapper")
                        .controller("controller")
                        .pathInfo(Collections.singletonMap(OutputFile.xml,
                                projectPath  + "/src/main/resources" + "/mapper")))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply(
                                "请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder()
                        .enableRestStyle()
                        .serviceBuilder()
                        .formatServiceFileName("%sService")
                        .entityBuilder()
                        .disableSerialVersionUID()
                        .enableLombok()
                        .superClass(BaseEntity.class)
                        .enableTableFieldAnnotation()
                        .enableRemoveIsPrefix()
                        .addSuperEntityColumns(
                                "delete_flag",
                                "create_by",
                                "create_on",
                                "update_by",
                                "update_on")
                        .mapperBuilder()
                        .mapperAnnotation(Mapper.class)
                        .build()).execute();
    }
    /** 处理 all 情况 */
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
