package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.sms.aliyun;

import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiChannel;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiChannelProperties;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(AliYunSmsApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiSmsAliyunProperties.class)
public class ThirdPartyApiSmsAliyunAutoConfiguration {
    /**
     * aliYunSmsClient.
     *
     * @return AliYunSmsClient
     */
    @Bean
    @ConditionalOnMissingBean
    public AliYunSmsClient aliYunSmsClient() {
        return new AliYunSmsClient();
    }

    /**
     * aliYunSmsApiChannel.
     *
     * @param properties properties
     * @param client     client
     * @return AliYunSmsApiChannel
     */
    @Bean
    @ConditionalOnMissingBean
    public AliYunSmsApiChannel aliYunSmsApiChannel(
            final AliYunSmsApiChannelProperties properties,
            final AliYunSmsClient client) {
        return new AliYunSmsApiChannel(properties, client);
    }
}