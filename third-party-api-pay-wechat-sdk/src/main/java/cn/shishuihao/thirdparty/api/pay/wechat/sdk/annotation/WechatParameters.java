package cn.shishuihao.thirdparty.api.pay.wechat.sdk.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface WechatParameters {
    /**
     * 多环境.
     *
     * @return WechatParameter[]
     */
    WechatParameter[] value();
}
