package com.test.pay.weixin.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonNaming(SnakeCaseStrategy.class)
@JsonIgnoreProperties
public class OrderVo implements Serializable {
	/** 应用ID */
	private String appid;
	/** 商户号 */
	private String mchId;
	/** 设备号 */
	private String deviceInfo;
	/** 随机字符串 */
	private String nonceStr;
	/** 签名 */
	private String sign;
	/** 商品描述 */
	private String body;
	/** 商品详情 */
	private String detail;
	/** 附加数据 */
	private String attach;
	/** 商户订单号 */
	private String outTradeNo;
	/** 货币类型 */
	private String feeType;
	/** 总金额 */
	private String totalFee;
	/** 终端IP */
	private String spbillCreateIp;
	/** 交易起始时间 */
	private String timeStart;
	/** 交易结束时间 */
	private String timeExpire;
	/** 商品标记 */
	private String goodsTag;
	/** 通知地址 */
	private String notifyUrl;
	/** 交易类型 */
	private String tradeType;
	/** 指定支付方式 */
	private String limitPay;

}
