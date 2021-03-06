package cn.shishuihao.thirdparty.api.push.huawei.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.huawei.HuaweiPushApiChannel;
import cn.shishuihao.thirdparty.api.push.huawei.HuaweiPushApiProperties;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class HuaweiPushMessageApiTest {

    @Test
    void execute() {
        HuaweiPushApiProperties properties = new HuaweiPushApiProperties();
        properties.setAppId("appId");
        ApiConfiguration configuration = ApiConfiguration.builder()
                .appId("appId")
                .channelId(properties.channelId())
                .properties(properties)
                .build();
        ApiRegistry.CONFIGURATION_REPOSITORY.save(configuration);
        PushMessageApiRequest request = PushMessageApiRequest.builder()
                .channelId(HuaweiPushApiChannel.CHANNEL_ID)
                .appId(configuration.getAppId())
                .title("title")
                .description("description")
                .payload("payload")
                .restrictedPackageName("restrictedPackageName")
                .registrationIds(new String[]{"registrationId"})
                .build();
        ApiException apiException = Assertions.assertThrows(ApiException.class, () -> ApiRegistry.INSTANCE.execute(request));
        Assertions.assertTrue(apiException.getMessage().startsWith("feign.FeignException: status 403"));
    }
}