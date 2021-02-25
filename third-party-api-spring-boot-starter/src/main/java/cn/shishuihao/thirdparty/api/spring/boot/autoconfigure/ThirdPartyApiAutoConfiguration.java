package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.ApiChannelRepository;
import cn.shishuihao.thirdparty.api.core.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.core.impl.memory.ChannelMemoryRepository;
import cn.shishuihao.thirdparty.api.core.impl.memory.PropertiesMemoryRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Import({ThirdPartyApiSpringContainer.class})
@Configuration
@ConditionalOnProperty(name = "third-party-api.enabled", matchIfMissing = true)
public class ThirdPartyApiAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesRepository propertiesRepository() {
        return new PropertiesMemoryRepository();
    }

    @Bean
    @ConditionalOnMissingBean
    protected ApiChannelRepository channelRepository() {
        return new ChannelMemoryRepository();
    }

    @Bean
    @ConditionalOnMissingBean
    protected ApiRegistry apiRegistry(ApiChannelRepository channelRepository) {
        return new ApiRegistry(channelRepository);
    }
}