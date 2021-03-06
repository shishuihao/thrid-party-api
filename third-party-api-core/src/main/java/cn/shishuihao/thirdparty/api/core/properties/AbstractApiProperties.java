package cn.shishuihao.thirdparty.api.core.properties;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
public abstract class AbstractApiProperties implements ApiProperties {
    /**
     * channel id.
     */
    private String channelId;

    /**
     * get channel id.
     *
     * @return channel id
     */
    @Override
    public String channelId() {
        return channelId;
    }

    /**
     * equals.
     *
     * @param o object
     * @return boolean
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractApiProperties)) {
            return false;
        }
        AbstractApiProperties that = (AbstractApiProperties) o;
        return Objects.equals(channelId, that.channelId)
                && Objects.equals(id(), that.id());
    }

    /**
     * hashCode.
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(channelId, id());
    }
}
