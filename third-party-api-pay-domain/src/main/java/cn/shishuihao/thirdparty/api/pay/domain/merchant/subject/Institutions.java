package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject;

import cn.shishuihao.thirdparty.api.pay.domain.merchant.bank_account.CorporateBankAccount;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.certificate.Certificate;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.organization.Organization;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 党政、机关及事业单位.
 * 包括国内各级、各类政府机构、事业单位等（如：公安、党团、司法、交通、旅游、工商税务、市政、医疗、教育、学校等机构）；
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Data
public class Institutions extends Subject<
        Certificate,
        CorporateBankAccount> {
    /**
     * 组织机构代码证.
     */
    private final Organization organization;

    /**
     * 主体类型.
     *
     * @return SubjectType
     */
    @Override
    public SubjectType getSubjectType() {
        return SubjectType.INSTITUTIONS;
    }
}
