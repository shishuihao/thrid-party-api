package cn.shishuihao.thirdparty.api.pay.sdk.api;

import cn.shishuihao.thirdparty.api.pay.sdk.request.PayV1TransactionsCloseRequest;
import cn.shishuihao.thirdparty.api.pay.sdk.request.PayV1TransactionsPlaceRequest;
import cn.shishuihao.thirdparty.api.pay.sdk.response.PayV1TransactionsCloseResponse;
import cn.shishuihao.thirdparty.api.pay.sdk.response.PayV1TransactionsJsApiResponse;
import feign.Param;
import feign.RequestLine;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface JsApiPayApi extends CommonPayApi {
    /**
     * 统一下单.
     *
     * @param outTradeNo 商户订单号
     * @param request    请求参数
     * @return response 响应参数
     */
    @RequestLine("POST /pay/v1/transactions/js-api")
    PayV1TransactionsJsApiResponse
    jsApiPay(@Param("outTradeNo") String outTradeNo,
             PayV1TransactionsPlaceRequest request);

    /**
     * 关闭订单.
     *
     * @param outTradeNo 商户订单号
     * @param request    请求参数
     * @return response 响应参数
     */
    @RequestLine("POST /pay/v1/transactions/{outTradeNo}/close")
    PayV1TransactionsCloseResponse
    close(@Param("outTradeNo") String outTradeNo,
          PayV1TransactionsCloseRequest request);
}
