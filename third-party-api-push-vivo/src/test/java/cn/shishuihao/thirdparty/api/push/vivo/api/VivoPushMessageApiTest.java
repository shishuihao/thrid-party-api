package cn.shishuihao.thirdparty.api.push.vivo.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.vivo.VivoPushApiChannel;
import cn.shishuihao.thirdparty.api.push.vivo.VivoPushApiProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class VivoPushMessageApiTest {

    @Test
    void execute() {
        VivoPushApiProperties properties = new VivoPushApiProperties();
        properties.setAppKey("appKey");
        properties.setSecret("secret");
        ApiConfiguration configuration = ApiConfiguration.builder()
                .appId("appId")
                .channelId(properties.channelId())
                .properties(properties)
                .build();
        ApiRegistry.CONFIGURATION_REPOSITORY.save(configuration);
        PushMessageApiRequest request = PushMessageApiRequest.builder()
                .channelId(VivoPushApiChannel.CHANNEL_ID)
                .appId(configuration.getAppId())
                .title("title")
                .description("description")
                .payload("payload")
                .restrictedPackageName("restrictedPackageName")
                .registrationIds(new String[]{"registrationId"})
                .build();
        ApiException apiException = Assertions.assertThrows(ApiException.class, () -> ApiRegistry.INSTANCE.execute(request));
        Assertions.assertEquals("java.lang.IllegalArgumentException: ParameterError: 10050, “alias和regId 不能都为空”", apiException.getMessage());
    }
}