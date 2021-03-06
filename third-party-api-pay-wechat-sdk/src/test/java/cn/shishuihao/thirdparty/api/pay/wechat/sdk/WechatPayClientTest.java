package cn.shishuihao.thirdparty.api.pay.wechat.sdk;

import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPayMicroPayRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPayOrderQueryRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPayRefundQueryRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayMicroPayResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayOrderQueryResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayRefundQueryResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WechatPayClientTest {
    final WechatPayClient client = new WechatPayClient();

    @Test
    void microPay() {
        WechatPayMicroPayResponse response = client.codeApi(null)
                .microPay(WechatPayMicroPayRequest.builder()
                        .appId("wx2421b1c4370ec43b")
                        .attach("订单额外描述")
                        .authCode("120269300684844649")
                        .body("付款码支付测试")
                        .deviceInfo("1000")
                        .goodsTag("")
                        .mchId("10000100")
                        .nonceStr("8aaee146b1dee7cec9100add9b96cbe2")
                        .outTradeNo("1415757673")
                        .spBillCreateIp("14.17.22.52")
                        .timeExpire("")
                        .totalFee(1)
                        .sign("C29DB7DB1FD4136B84AE35604756362C")
                        .build());
        Assertions.assertEquals("FAIL", response.getReturnCode());
    }

    @Test
    void orderQuery() {
        WechatPayOrderQueryResponse response = client.commonApi(null)
                .orderQuery(WechatPayOrderQueryRequest.builder()
                        .appId("wx2421b1c4370ec43b")
                        .mchId("10000100")
                        .nonceStr("ec2316275641faa3aacf3cc599e8730f")
                        .transactionId("1008450740201411110005820873")
                        .sign("FDD167FAA73459FD921B144BAF4F4CA2")
                        .build());
        Assertions.assertEquals("SUCCESS", response.getReturnCode());
    }

    @Test
    void refundQuery() {
        WechatPayRefundQueryResponse response = client.commonApi(null)
                .refundQuery(WechatPayRefundQueryRequest.builder()
                        .appId("wx2421b1c4370ec43b")
                        .mchId("10000100")
                        .nonceStr("0b9f35f484df17a732e537c37708d1d0")
                        .outRefundNo("")
                        .outTradeNo("1415757673")
                        .refundId("")
                        .transactionId("")
                        .sign("66FFB727015F450D167EF38CCC549521")
                        .build());
        Assertions.assertEquals("SUCCESS", response.getReturnCode());
    }
}