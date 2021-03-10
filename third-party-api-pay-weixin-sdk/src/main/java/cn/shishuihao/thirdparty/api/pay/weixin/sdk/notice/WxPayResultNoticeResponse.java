package cn.shishuihao.thirdparty.api.pay.weixin.sdk.notice;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.annotation.WxParameter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * 商户处理后同步返回给微信参数.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
@XStreamAlias("xml")
public class WxPayResultNoticeResponse {
    // region 返回信息.
    /**
     * 返回状态码.
     */
    @WxParameter(
            name = "返回状态码",
            required = true, type = "String(16)",
            example = "SUCCESS",
            desc = "SUCCESS/FAIL\n此字段是通信标识，表示接口层的请求结果，并非退款状态。")
    @XStreamAlias("return_code")
    private final String returnCode;
    /**
     * 返回信息.
     */
    @WxParameter(
            name = "返回信息",
            required = false, type = "String(128)",
            example = "OK",
            desc = "返回信息，如非空，为错误原因\n签名失败\n参数格式校验错误")
    @XStreamAlias("return_msg")
    private final String returnMsg;
}
