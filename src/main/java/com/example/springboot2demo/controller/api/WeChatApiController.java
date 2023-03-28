package com.example.springboot2demo.controller.api;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot2demo.Springboot2demoApplication;
import com.example.springboot2demo.model.vo.WeChatConfigVO;
import com.example.springboot2demo.model.vo.WeChatTemplateMsg;
import com.example.springboot2demo.model.vo.WeChatVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xnd
 * @since 2023/3/27 13:47
 */
@Slf4j
@Api(tags = "微信开放Api")
@RestController
@RequestMapping("/api/weiXinLoginAuth")
public class WeChatApiController {
    //以实体类返回的形式读取配置文件信息
    @Autowired
    private WeChatConfigVO weChatConfigVO;
//   通过Value注解读取配置文件信息
//    @Value("${wx.config.appId}")
//   private   String appId;
//    @Value("${wx.config.appSecret}")
//   private   String appSecret;

    //1.先查询code
    @GetMapping("/getCode")
    public String getCode() {
        // 官方地址
        String urlFir = "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=";
        // 微信申请的域名(提前准备)
        String domain = "http://kecc2a.natappfree.cc";
        // 自定义跳转方法
        String redirectMethod = "/api/weiXinLoginAuth/wxpay/weXinLoginAuth";
        // 地址进行encode转译 (未转译的地址是：http://pay.xxx.cn/wxpay/weixinoauth)
        // 转译后的地址是: http%3A%2F%2Fpay.xxx.cn%2Fwxpay%2Fweixinoauth
        String encoderUrl = getURLEncoderString(domain + redirectMethod);
        log.info(urlFir +weChatConfigVO.getAppId() + "&redirect_uri=" + encoderUrl +"&response_type=code&scope=snsapi_userinfo" +
                "&state=STATE" + "#wechat_redirect");
        return urlFir + weChatConfigVO.getAppId() + "&redirect_uri=" + encoderUrl +"&response_type=code&scope=snsapi_userinfo" +
                "&state=STATE" +
                "#wechat_redirect";
    }


    //2.根据code获取openId
    @GetMapping("/wxpay/weXinLoginAuth")
    public WeChatVO weXinLoginAuth(@RequestParam String code) throws Exception {
        log.info("获取code:{}",code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
                + weChatConfigVO.getAppId() + "&secret=" + weChatConfigVO.getAppSecret() + "&code=" + code + "&grant_type" +
                "=authorization_code";
        Map<String, Object> paramMap = null;
        String res = HttpUtil.get(url, paramMap);
        WeChatVO wxLoginVOx = JSONObject.parseObject(res, WeChatVO.class);
        String openId = wxLoginVOx.getOpenId();
        wxLoginVOx.setOpenId(openId);
        String accessToken = getAccessToken();
        wxLoginVOx.setAccessToken(accessToken);
//        String message = sendMessage(openId,accessToken);
        log.info("根据code查询得到openId:{}",openId);
        log.info("根据code查询得到accessToken:{}",accessToken);
//        log.info("模板消息内容{}",message);
     return wxLoginVOx;
    }

    @GetMapping("/getToken")
    //获取微信基础accessToken
    public String getAccessToken() throws Exception{
        String url =
                "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+ weChatConfigVO.getAppId() +
                        "&secret=" + weChatConfigVO.getAppSecret();
        String res = HttpUtil.get(url);
        JSONObject jsonObject = JSONObject.parseObject(res);
        String accessToken = jsonObject.getString("access_token");
        log.info("accessToken：{}", accessToken);
        return accessToken;
    }

    /**
     *  其他模板可以从模板库中自己添加
     * 模板ID
     * GHJNUoZtoVvAs2FD7c0ATtdUqONBMkIj2SOh6nNT7EQ
     * 开发者调用模板消息接口时需提供模板ID
     * 标题
     * 门诊缴费成功提醒
     * 行业
     * 医疗护理 - 医药医疗
     * 详细内容:
     * {{first.DATA}}
     * 用户姓名：{{keynote1.DATA}}
     * 订单号：{{keynote2.DATA}}
     * 缴费金额：{{keynote3.DATA}}
     * 医生：{{keynote4.DATA}}
     * 科室：{{keynote5.DATA}}
     * 医院：{{keynote6.DATA}}
     * 缴费日期：{{keynote7.DATA}}
     * {{remark.DATA}}
     */
    @GetMapping("/sendMessage")
    public String sendMessage(String openId, String accessToken) throws Exception {
        // 模板参数
        Map<String, WeChatTemplateMsg> sendMag = new HashMap<String, WeChatTemplateMsg>();
        // openId代表一个唯一微信用户，即微信消息的接收人
//        String openId = "oCuOVwx86jEja8CTGzzhs2D-D6ng";
        // 公众号的模板id(也有相应的接口可以查询到)
        String templateId = "GHJNUoZtoVvAs2FD7c0ATtdUqONBMkIj2SOh6nNT7EQ";
        // 微信的基础accessToken
//        String accessToken = getAccessToken();
        // String accessToken = "67_6UbZdZoUhOQ" +
         //        "-QSyuHmUvEy1TZHVIr4Bjkdhtg751X1LquRM93xk7PGXQyt1pWFF6MHlIOBXWVVdzaGwHD1IqWUAQ8YTvdT_fu2ipAYZ0NHU";
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + accessToken;
        //推送模板详情
        sendMag.put("first", new WeChatTemplateMsg("f123"));
        sendMag.put("keynote1", new WeChatTemplateMsg("111"));
        sendMag.put("keynote2", new WeChatTemplateMsg("222"));
        sendMag.put("keynote3", new WeChatTemplateMsg("333"));
        sendMag.put("keynote4", new WeChatTemplateMsg("444"));
        sendMag.put("keynote5", new WeChatTemplateMsg("444"));
        sendMag.put("keynote6", new WeChatTemplateMsg("444"));
        sendMag.put("keynote7", new WeChatTemplateMsg("444"));
        sendMag.put("remark", new WeChatTemplateMsg("r555"));
        RestTemplate restTemplate = new RestTemplate();
        //拼接base参数
        Map<String, Object> sendBody = new HashMap<>();
        sendBody.put("touser", openId);               // openId
        sendBody.put("url", "www.baidu.com");         // 点击模板信息跳转地址
        sendBody.put("topcolor", "#FF0000");          // 顶色
        sendBody.put("data", sendMag);                   // 模板参数
        sendBody.put("template_id", templateId);      // 模板Id
        ResponseEntity<String> forEntity = restTemplate.postForEntity(url, sendBody, String.class);
        log.info("结果是: {}",forEntity.getBody());
        JSONObject jsonObject = JSONObject.parseObject(forEntity.getBody());
        // 0
        assert jsonObject != null;
        String messageCode = jsonObject.getString("errcode");
        // 2431260672639467520
        String msgId = jsonObject.getString("msgid");
        System.out.println("messageCode : " + messageCode + ", msgId: " +msgId);
        return forEntity.getBody();
    }

    /**
     * 编码
     * @param str
     * @return
     */
    public static String getURLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
