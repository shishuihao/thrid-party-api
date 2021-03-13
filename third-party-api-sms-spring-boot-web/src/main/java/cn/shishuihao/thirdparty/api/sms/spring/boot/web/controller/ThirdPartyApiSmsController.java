package cn.shishuihao.thirdparty.api.sms.spring.boot.web.controller;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsApiResponse;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.CompletableFuture;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@RequestMapping("/api/v1/sms")
public class ThirdPartyApiSmsController {
    /**
     * send sms.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/send")
    public CompletableFuture<SendSmsApiResponse> send(
            @RequestBody final SendSmsApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                ApiRegistry.INSTANCE.execute(request));
    }

    /**
     * send batch sms.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/send-batch")
    public CompletableFuture<SendBatchSmsApiResponse> sendBatch(
            @RequestBody final SendBatchSmsApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                ApiRegistry.INSTANCE.execute(request));
    }
}
