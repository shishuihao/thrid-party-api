package cn.shishuihao.thirdparty.api.pay.wechat.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.WechatPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.wechat.WechatPayApiProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WechatCodePayApiTest {
    WechatPayApiProperties properties = new WechatPayApiProperties();
    ApiConfiguration configuration;

    @BeforeEach
    void beforeEach() {
        properties.setAppId("appId");
        properties.setKey("key");
        properties.setMchId("mchId");
        configuration = ApiConfiguration.builder()
                .appId("appId")
                .channelId(properties.channelId())
                .properties(properties)
                .build();
        ApiRegistry.CONFIGURATION_REPOSITORY.save(configuration);
    }

    @Test
    void execute() {
        CodePayApiRequest request = CodePayApiRequest.builder()
                .channelId(WechatPayApiChannel.CHANNEL_ID)
                .appId(configuration.getAppId())
                .subject("Apple iPhone11 128G")
                .outTradeNo("2234567890")
                .totalAmount(1)
                .authCode("")
                .build();
        Assertions.assertEquals("mch_id参数格式错误", ApiRegistry.INSTANCE.execute(request).getMessage());
    }
}