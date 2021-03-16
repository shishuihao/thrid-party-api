package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.icbc;

import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiChannelProperties;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayClient;
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
@ConditionalOnClass(IcbcPayApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPayIcbcProperties.class)
public class ThirdPartyApiPayIcbcAutoConfiguration {
    /**
     * icbcPayClient.
     *
     * @return IcbcPayClient
     */
    @Bean
    @ConditionalOnMissingBean
    public IcbcPayClient icbcPayClient() {
        return new IcbcPayClient();
    }

    /**
     * icbcPayApiChannel.
     *
     * @param properties properties
     * @param client     client
     * @return IcbcPayApiChannel
     */
    @Bean
    @ConditionalOnMissingBean
    public IcbcPayApiChannel icbcPayApiChannel(
            final IcbcPayApiChannelProperties properties,
            final IcbcPayClient client) {
        return new IcbcPayApiChannel(properties, client);
    }
}