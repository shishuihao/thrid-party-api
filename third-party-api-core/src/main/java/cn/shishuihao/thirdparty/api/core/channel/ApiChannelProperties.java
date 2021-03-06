package cn.shishuihao.thirdparty.api.core.channel;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.repository.AggregateRoot;

import java.util.List;
import java.util.Map;

/**
 * @param <P> api properties
 * @author shishuihao
 * @version 1.0.0
 */

public interface ApiChannelProperties<
        P extends ApiProperties>
        extends AggregateRoot<String> {
    /**
     * get channel id.
     *
     * @return channel id
     */
    String channelId();

    /**
     * get configurations.
     *
     * @return configurations
     */
    Map<String, List<P>> getConfigurations();

    /**
     * get id.
     *
     * @return id
     */
    @Override
    default String id() {
        return this.channelId();
    }
}
