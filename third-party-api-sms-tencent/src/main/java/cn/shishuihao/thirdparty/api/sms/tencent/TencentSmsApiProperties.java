package cn.shishuihao.thirdparty.api.sms.tencent;

import cn.shishuihao.thirdparty.api.sms.properties.AbstractSmsApiProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(of = {"secretId", "appId"}, callSuper = true)
@Getter
@Setter
public class TencentSmsApiProperties extends AbstractSmsApiProperties {
    /**
     * 用于标识 API 调用者的身份.
     */
    private String secretId;
    /**
     * 短信应用 ID.
     * 在 [短信控制台] 添加应用后生成的实际 SDKAppID，例如1400006666
     */
    private String appId;
    /**
     * 用于加密签名字符串和服务器端验证签名字符串的密钥.
     * SecretKey 需妥善保管，避免泄露。
     */
    private String secretKey;
    /**
     * 短信签名内容.
     * 使用 UTF-8 编码，必须填写已审核通过的签名，签名信息可登录 短信控制台 查看。注：国内短信为必填参数。
     */
    private String sign;
    /**
     * 国内短信无senderid，无需填写该项.
     * 若需开通国际/港澳台短信senderid，请联系smshelper。
     */
    private String senderId;
    /**
     * 短信码号扩展号.
     * 默认未开通，如需开通请联系 sms helper。
     */
    private String extendCode;

    /**
     * new TencentSmsApiProperties.
     */
    public TencentSmsApiProperties() {
        this.setChannelId(TencentSmsApiChannel.CHANNEL_ID);
    }

    /**
     * get id.
     *
     * @return id
     */
    @Override
    public String id() {
        return String.join(":", secretId, appId);
    }
}
