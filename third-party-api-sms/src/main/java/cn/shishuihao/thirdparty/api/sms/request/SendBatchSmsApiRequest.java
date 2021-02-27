package cn.shishuihao.thirdparty.api.sms.request;

import cn.shishuihao.thirdparty.api.sms.SmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.api.SendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.domain.SmsMessage;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsApiResponse;

import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class SendBatchSmsApiRequest implements SmsApiRequest<SendBatchSmsApi, SendBatchSmsApiRequest, SendBatchSmsApiResponse> {
    /**
     * channel id
     */
    private final String channelId;
    /**
     * properties id
     */
    private final String propertiesId;
    /**
     * template Id
     */
    private final String templateId;
    /**
     * phone numbers
     */
    private final List<SmsMessage> messages;

    protected SendBatchSmsApiRequest(String channelId, String propertiesId, String templateId, List<SmsMessage> messages) {
        this.channelId = channelId;
        this.propertiesId = propertiesId;
        this.templateId = templateId;
        this.messages = messages;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getPropertiesId() {
        return propertiesId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public List<SmsMessage> getMessages() {
        return messages;
    }

    @Override
    public Class<SendBatchSmsApi> apiType() {
        return SendBatchSmsApi.class;
    }

    @Override
    public Class<SendBatchSmsApiResponse> responseType() {
        return SendBatchSmsApiResponse.class;
    }

    @Override
    public String channelId() {
        return channelId;
    }

    @Override
    public String propertiesId() {
        return propertiesId;
    }


    public static final class Builder {
        private String channelId;
        private String propertiesId;
        private String templateId;
        private List<SmsMessage> messages;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder channelId(String channelId) {
            this.channelId = channelId;
            return this;
        }

        public Builder propertiesId(String propertiesId) {
            this.propertiesId = propertiesId;
            return this;
        }

        public Builder templateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        public Builder messages(List<SmsMessage> messages) {
            this.messages = messages;
            return this;
        }

        public SendBatchSmsApiRequest build() {
            return new SendBatchSmsApiRequest(channelId, propertiesId, templateId, messages);
        }
    }
}
