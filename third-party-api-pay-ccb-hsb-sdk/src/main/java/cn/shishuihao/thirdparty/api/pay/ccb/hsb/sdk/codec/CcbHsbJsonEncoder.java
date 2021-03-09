package cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.codec;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;

import java.lang.reflect.Type;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbHsbJsonEncoder implements Encoder {
    /**
     * INSTANCE.
     */
    public static final CcbHsbJsonEncoder INSTANCE = new CcbHsbJsonEncoder();

    /**
     * encode request.
     *
     * @param object   request
     * @param bodyType body type
     * @param template request template
     * @throws EncodeException EncodeException
     */
    @Override
    public void encode(final Object object,
                       final Type bodyType,
                       final RequestTemplate template) throws EncodeException {
        template.body(JacksonUtils.toJson(object));
    }
}