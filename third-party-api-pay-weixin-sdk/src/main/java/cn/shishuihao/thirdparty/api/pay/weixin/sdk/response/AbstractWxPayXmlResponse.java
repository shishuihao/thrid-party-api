package cn.shishuihao.thirdparty.api.pay.weixin.sdk.response;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.annotation.WxParameter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
public abstract class AbstractWxPayXmlResponse {
    /**
     * 返回状态码.
     */
    @WxParameter(
            name = "返回状态码",
            required = true, type = "String(16)",
            example = "SUCCESS",
            desc = "SUCCESS/FAIL\n此字段是通信标识，表示接口层的请求结果，并非退款状态。")
    @XStreamAlias("return_code")
    private String returnCode;
    /**
     * 返回信息.
     */
    @WxParameter(
            name = "返回信息",
            required = false, type = "String(128)",
            example = "签名失败",
            desc = "返回信息，如非空，为错误原因\n签名失败\n参数格式校验错误")
    @XStreamAlias("return_msg")
    private String returnMsg;

    //region 当return_code为SUCCESS的时候，还会包括以下字段

    /**
     * 业务结果.
     */
    @WxParameter(
            name = "业务结果",
            required = true, type = "String(16)",
            example = "SUCCESS",
            desc = "SUCCESS/FAIL")
    @XStreamAlias("result_code")
    private String resultCode;
    /**
     * 错误代码.
     */
    @WxParameter(
            name = "错误代码",
            required = true, type = "String(32)",
            example = "SYSTEMERROR",
            desc = "详细参见错误列表")
    @XStreamAlias("err_code")
    private String errCode;
    /**
     * 错误描述.
     */
    @WxParameter(
            name = "错误描述",
            required = true, type = "String(128)",
            example = "系统错误",
            desc = "结果信息描述")
    @XStreamAlias("err_code_des")
    private String errCodeDes;


    /**
     * 公众账号ID|应用ID|小程序ID.
     */
    @WxParameter(
            name = "公众账号ID|应用ID|小程序ID",
            required = true, type = "String(32)",
            example = "wx8888888888888888",
            desc = "公众账号ID|应用ID|小程序ID")
    @XStreamAlias("appid")
    private String appId;
    /**
     * 商户号.
     * 1900000109
     * 微信支付分配的商户号
     */
    @WxParameter(
            name = "商户号",
            required = true, type = "String(32)",
            example = "1900000109",
            desc = "商户号")
    @XStreamAlias("mch_id")
    private String mchId;
    /**
     * 子商户公众账号ID|子商户应用ID|子商户小程序ID.
     */
    @WxParameter(
            name = "子商户公众账号ID|子商户应用ID|子商户小程序ID",
            required = true, type = "String(32)",
            example = "wx8888888888888888",
            desc = "子商户公众账号ID|子商户应用ID|子商户小程序ID")
    @XStreamAlias("sub_appid")
    private String subAppId;
    /**
     * 子商户号.
     */
    @WxParameter(
            name = "子商户号",
            required = true, type = "String(32)",
            example = "1900000109",
            desc = "子商户号")
    @XStreamAlias("sub_mch_id")
    private String subMchId;
    /**
     * 设备号.
     */
    @WxParameter(
            name = "设备号",
            required = false, type = "String(32)",
            example = "013467007045764",
            desc = "微信支付分配的终端设备号")
    @XStreamAlias("device_info")
    private String deviceInfo;
    /**
     * 随机字符串.
     */
    @WxParameter(
            name = "随机字符串",
            required = true, type = "String(32)",
            example = "5K8264ILTKCH16CQ2502SI8ZNMTM67VS",
            desc = "随机字符串，不长于32位")
    @XStreamAlias("nonce_str")
    private String nonceStr;
    /**
     * 签名.
     */
    @WxParameter(
            name = "签名",
            required = true, type = "String(32)",
            example = "C380BEC2BFD727A4B6845133519F3AD6",
            desc = "签名，详见签名算法")
    @XStreamAlias("sign")
    private String sign;
}
