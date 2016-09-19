package com.sanying.trust.pay.alipay;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.sanying.trust.pay.alipay.config.AlipayDefaultConfig;

public class AlipayService {
	
	/**
	 * 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，
	 * 查看地址：https://b.alipay.com/order/pidAndKey.htm
	 */
	private String partner;
	
	/** 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号 （不填默认取值：partner） */
	private String sellerID;
	
	/**
	 * 合作伙伴 -商户的私钥,需要PKCS8格式,RSA公私钥生成：
	 * https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&
	 * treeId=58&articleId=103242&docType=1
	 */
	private String partnerPrivateKey;
	
	/** 合作伙伴 - 支付宝的公钥,查看地址：https://b.alipay.com/order/pidAndKey.htm */
	private String partnerAlipayPublicKey;
	
	/** 开发平台 - 开放平台密钥 */
	private String platformPrivateKey;
	
	/** 开发平台 - 支付宝的公钥,查看地址：https://b.alipay.com/order/pidAndKey.htm */
	private String platformAlipayPublicKey;
	
	/** 异步通知回调地址 */
	private String notifyUrl;
	
	/** 及时到账同步回掉地址 */
	private String returnUrl;

	/**
	 * 建立请求，以表单HTML形式构造（默认）
	 * 
	 * @param outTradeNo
	 *            商户订单号，商户网站订单系统中唯一订单号
	 * @param subject
	 *            订单名称
	 * @param totalFee
	 *            付款金额
	 * @param body
	 *            商品描述
	 * @return 提交表单HTML文本
	 */
	public String buildRequest(String outTradeNo, String subject, String totalFee, String body) {
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", AlipayDefaultConfig.SERVICE);
		sParaTemp.put("partner", partner);
		sParaTemp.put("seller_id", StringUtils.isNotBlank(sellerID) ? sellerID : partner);
		sParaTemp.put("_input_charset", AlipayDefaultConfig.INPUT_CHARSET);
		sParaTemp.put("payment_type", AlipayDefaultConfig.PAYMENT_TYPE);
		sParaTemp.put("anti_phishing_key", AlipayDefaultConfig.ANTI_PHISHING_KEY);
		sParaTemp.put("exter_invoke_ip", AlipayDefaultConfig.EXTER_INVOKE_IP);
		sParaTemp.put("out_trade_no", outTradeNo);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", totalFee);
		sParaTemp.put("body", body);
		sParaTemp.put("notify_url", notifyUrl);
		sParaTemp.put("return_url", returnUrl);
		return AlipaySubmit.buildRequest(sParaTemp, partnerPrivateKey, "get", "确认");
	}

	public boolean verify(Map<String, String> params) {
		if (StringUtils.isNotBlank(params.get("app_id"))) {
			boolean bo = AlipayNotify.verify(params, platformAlipayPublicKey, partner);
			params.put("total_fee", params.get("total_amount"));
			return bo;
		} else {
			return AlipayNotify.verify(params, partnerAlipayPublicKey, partner);
		}
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getSellerID() {
		return sellerID;
	}

	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}

	public String getPartnerPrivateKey() {
		return partnerPrivateKey;
	}

	public void setPartnerPrivateKey(String partnerPrivateKey) {
		this.partnerPrivateKey = partnerPrivateKey;
	}

	public String getPartnerAlipayPublicKey() {
		return partnerAlipayPublicKey;
	}

	public void setPartnerAlipayPublicKey(String partnerAlipayPublicKey) {
		this.partnerAlipayPublicKey = partnerAlipayPublicKey;
	}



	public String getPlatformPrivateKey() {
		return platformPrivateKey;
	}

	public void setPlatformPrivateKey(String platformPrivateKey) {
		this.platformPrivateKey = platformPrivateKey;
	}

	public String getPlatformAlipayPublicKey() {
		return platformAlipayPublicKey;
	}

	public void setPlatformAlipayPublicKey(String platformAlipayPublicKey) {
		this.platformAlipayPublicKey = platformAlipayPublicKey;
	}

}
