package cn.shishuihao.thirdparty.api.push.xiaomi;

import cn.shishuihao.thirdparty.api.core.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.impl.memory.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.push.PushApiChannel;
import cn.shishuihao.thirdparty.api.push.xiaomi.api.XiaomiPushMessageApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushApiChannel extends AbstractMemoryChannel<XiaomiPushApiProperties> implements PushApiChannel<XiaomiPushApiProperties> {
    private final XiaomiPushProperties channelProperties;

    public XiaomiPushApiChannel(XiaomiPushProperties channelProperties,
                                ApiPropertiesRepository propertiesRepository) {
        this.channelProperties = channelProperties;
        this.add(new XiaomiPushMessageApi(propertiesRepository));
    }

    public XiaomiPushApiChannel() {
        this(new XiaomiPushProperties(), ApiRegistry.PROPERTIES_REPOSITORY);
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }

    @Override
    public Class<XiaomiPushApiProperties> propertiesType() {
        return XiaomiPushApiProperties.class;
    }
}