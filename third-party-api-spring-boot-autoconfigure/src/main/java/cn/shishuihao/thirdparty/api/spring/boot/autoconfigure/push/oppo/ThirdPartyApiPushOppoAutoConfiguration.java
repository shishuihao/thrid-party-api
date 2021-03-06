package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.push.oppo;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.push.oppo.OppoPushApiChannel;
import cn.shishuihao.thirdparty.api.push.oppo.OppoPushApiChannelProperties;
import cn.shishuihao.thirdparty.api.push.oppo.OppoPushClient;
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
@ConditionalOnClass(OppoPushApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPushOppoProperties.class)
public class ThirdPartyApiPushOppoAutoConfiguration {
    /**
     * oppoPushClient.
     *
     * @return OppoPushClient
     */
    @Bean
    @ConditionalOnMissingBean
    public OppoPushClient oppoPushClient() {
        return new OppoPushClient();
    }

    /**
     * oppoPushApiChannel.
     *
     * @param propertiesRepository properties repository
     * @param properties           properties
     * @param client               client
     * @return OppoPushApiChannel
     */
    @Bean
    @ConditionalOnMissingBean
    public OppoPushApiChannel oppoPushApiChannel(
            final ApiConfigurationRepository propertiesRepository,
            final OppoPushApiChannelProperties properties,
            final OppoPushClient client) {
        properties.getConfigurations()
                .forEach((key, list) -> list.forEach(value ->
                        propertiesRepository.save(ApiConfiguration.builder()
                                .appId(key)
                                .channelId(properties.channelId())
                                .properties(value)
                                .build())));
        return new OppoPushApiChannel(properties, client);
    }
}
