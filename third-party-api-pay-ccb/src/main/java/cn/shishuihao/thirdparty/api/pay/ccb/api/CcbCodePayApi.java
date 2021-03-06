package cn.shishuihao.thirdparty.api.pay.ccb.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.CcbPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.ccb.assembler.CcbPayRequestAssembler;
import cn.shishuihao.thirdparty.api.pay.ccb.assembler.CcbPayResponseAssembler;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.CcbPayClient;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class CcbCodePayApi implements CodePayApi {
    /**
     * CcbPayClient.
     */
    private final CcbPayClient client;

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public CodePayApiResponse execute(final CodePayApiRequest request) {
        final CcbPayApiProperties properties = (CcbPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            return CcbPayResponseAssembler.INSTANCE
                    .assemble(client
                            .scannedPayApi(properties)
                            .codePay(client.urlInfo(properties)
                                            .getChannelName(),
                                    CcbPayRequestAssembler.INSTANCE
                                            .assemble(request, properties)));
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
