package com.sanying.trust.pay.wxpay;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sanying.trust.pay.exception.PayException;
import com.sanying.trust.pay.utils.HttpRequest;
import com.sanying.trust.pay.utils.QRCode;
import com.sanying.trust.pay.utils.Signature;
import com.sanying.trust.pay.wxpay.config.WxpayDefaultConfig;
import com.sanying.trust.pay.wxpay.protocol.ProtocolBase;
import com.sanying.trust.pay.wxpay.protocol.unifiedorder.OrderReq;
import com.sanying.trust.pay.wxpay.protocol.unifiedorder.OrderResp;

public class WxpayService {
	private static Logger LOGGER = LoggerFactory.getLogger(WxpayService.class);
	private static BigDecimal HUNDRED = new BigDecimal(100);
	private XmlMapper mapper = new XmlMapper();
	// 这个就是自己要保管好的私有Key了（切记只能放在自己的后台代码里，不能放在任何可能被看到源代码的客户端程序中）
	// 每次自己Post数据给API的时候都要用这个key来对所有字段进行签名，生成的签名会放在Sign这个字段，API收到Post数据的时候也会用同样的签名算法对Post过来的数据进行签名和验证
	// 收到API的返回的时候也要用这个key来对返回的数据算下签名，跟API的Sign数据进行比较，如果值不一致，有可能数据被第三方给篡改
	private String key;
	/** 微信分配的公众号ID（开通公众号之后可以获取到） */
	private String appid;
	/** 微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到） */
	private String mchId;
	/** 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。 */
	private String notifyUrl;

	@SuppressWarnings("unchecked")
	public String createOrder(String outTradeNo, BigDecimal amt, String subject, String createIp) {
		LOGGER.debug("创建微信支付订单 - outTradeNo:{} | amt:{} | subject:{} | createIp:{}", outTradeNo, amt, subject, createIp);
		OrderReq req = new OrderReq();
		req.setAppid(appid);
		req.setMchId(mchId);
		req.setNonceStr(getNonceStr());
		req.setBody(subject);
		req.setOutTradeNo(outTradeNo);
		req.setTotalFee(amt.multiply(HUNDRED).intValue());
		req.setSpbillCreateIp(createIp);
		req.setNotifyUrl(notifyUrl);
		req.setTradeType("NATIVE");
		try {
			Map<String, Object> signMap = mapper.convertValue(req, HashMap.class);
			req.setSign(Signature.getSign(signMap, key));
			String respTex = HttpRequest.post(WxpayDefaultConfig.URL_UNIFIEDORDER, mapper.writeValueAsString(req));
			OrderResp resp = mapper.readValue(respTex, OrderResp.class);
			if (WxpayDefaultConfig.RETURN_CODE_SUCCESS.equals(resp.getReturnCode()) && WxpayDefaultConfig.RESULT_CODE_SUCCESS.equals(resp.getResultCode())) {
				if (verify(resp)) {
					return QRCode.createQRCode(resp.getCodeUrl());
				} else {
					throw new PayException("签名错误");
				}
			} else {
				throw new PayException("创建订单出现异常 - " + resp.getReturnMsg());
			}
		} catch (IOException e) {
			throw new PayException("创建订单出现异常", e);
		}
	}

	public <T extends ProtocolBase> T read(String text, Class<T> clas) {
		try {
			return mapper.readValue(text, clas);
		} catch (IOException e) {
			throw new PayException("to object exception", e);
		}
	}

	public String readToString(ProtocolBase protocol) {
		try {
			return mapper.writeValueAsString(protocol);
		} catch (JsonProcessingException e) {
			throw new PayException("to xml exception", e);
		}
	}

	@SuppressWarnings("unchecked")
	public boolean verify(ProtocolBase protocol) {
		Map<String, Object> signMap = mapper.convertValue(protocol, HashMap.class);
		String sign = (String) signMap.remove("sign");
		String result = Signature.getSign(signMap, key);
		return result.equals(sign);
	}

	private String getNonceStr() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
}
