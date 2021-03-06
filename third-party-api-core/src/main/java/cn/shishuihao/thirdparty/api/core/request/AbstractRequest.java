package cn.shishuihao.thirdparty.api.core.request;

import cn.shishuihao.thirdparty.api.core.api.Api;
import cn.shishuihao.thirdparty.api.core.response.ApiResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

/**
 * @param <A> api
 * @param <T> api request
 * @param <R> api response
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
public abstract class AbstractRequest<
        A extends Api<A, T, R>,
        T extends ApiRequest<A, T, R>,
        R extends ApiResponse> {
    /**
     * app id.
     */
    @NotBlank
    private final String appId;
    /**
     * channel id.
     */
    @NotBlank
    private final String channelId;

    /**
     * get app id.
     *
     * @return String
     */
    public String appId() {
        return appId;
    }

    /**
     * get channel id.
     *
     * @return String
     */
    public String channelId() {
        return channelId;
    }
}
