package com.example.springboot2demo.common.exeirtorCommon.config.redis;

import com.esotericsoftware.kryo.util.ObjectMap;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author xnd
 * @since 2023/4/20 10:26
 */
@Data
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {
    private String host;

    private int port;

    private String password;

    private Integer timeOut;

    private Integer database;

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        log.info("redis地址{}",host);
        redisStandaloneConfiguration.setHostName(host);
        log.info("redis端口{}",port);
        redisStandaloneConfiguration.setPort(port);
        log.info("redis密码{}",password);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        log.info("redis数据库{}",database);
        redisStandaloneConfiguration.setDatabase(database);

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //解决查询缓存转换异常的问题
        ObjectMapper om = new ObjectMapper();
        //解决LocalDataTime序列化问题
        //LocalDataTime序列化
        JavaTimeModule timeModule = new JavaTimeModule();
        timeModule.addDeserializer(LocalDate.class,
                new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        timeModule.addDeserializer(LocalDateTime.class,
                new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        timeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        timeModule.addSerializer(LocalDateTime.class,
                new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        om.registerModule(timeModule);
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.WRAPPER_ARRAY);
        // fastjson redis 的序列化构造 自定义需求才使用否者使用GenericFastJsonRedisSerializer
        //FastJsonRedisSerializer<Object> serializer = new FastJsonRedisSerializer<>(Object.class);
        StringRedisSerializer serializer = new StringRedisSerializer();
        GenericJackson2JsonRedisSerializer fastJsonRedisSerializer = new GenericJackson2JsonRedisSerializer(om);
        LettuceConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfiguration);
        // 手动注入需要执行此方法,spring注入不需要 LettuceConnectionFactory 的初始化
        factory.afterPropertiesSet();

        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
        redisTemplate.setConnectionFactory(factory);
        // 手动注入需要执行此方法,spring注入不需要 放在最后
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
    /**
     * 设置 redis 数据默认过期时间
     * 设置@cacheable 序列化方式
     *
     * @return
     */
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        GenericJackson2JsonRedisSerializer fastJsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(
                fastJsonRedisSerializer)).entryTtl(Duration.ofMinutes(timeOut));
        return configuration;
    }

    /**
     * 服务停止后调用 shutdown 方法
     *
     * @return
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() {
        // 1.创建配置
        Config config = new Config();
        // 集群模式
        // config.useClusterServers().addNodeAddress("127.0.0.1:7004", "127.0.0.1:7001");
        // 2.根据 Config 创建出 RedissonClient 示例。
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://" + host + ":" + port);
        singleServerConfig.setDatabase(database);
        singleServerConfig.setPassword(password);
        return Redisson.create(config);
    }


}
