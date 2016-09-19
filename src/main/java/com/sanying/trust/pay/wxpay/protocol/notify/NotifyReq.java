package com.sanying.trust.pay.wxpay.protocol.notify;

import com.sanying.trust.pay.wxpay.protocol.ProtocolReq;

public class NotifyReq extends ProtocolReq {
	private static final long serialVersionUID = -747894322220915093L;
	/** 返回状态码 */
	private String returnCode;
	/** 返回信息 */
	private String returnMsg;
	/** 公众账号ID */
	private String appid;
	/** 商户号 */
	private String mchId;
	/** 设备号 */
	private String deviceInfo;
	/** 随机字符串 */
	private String nonceStr;
	/** 签名 */
	private String sign;
	/** 业务结果 */
	private String resultCode;
	/** 错误代码 */
	private String errCode;
	/** 错误代码描述 */
	private String errCodeDes;
	/** 用户标识 */
	private String openid;
	/** 是否关注公众账号 */
	private String isSubscribe;
	/** 交易类型 */
	private String tradeType;
	/** 付款银行 */
	private String bankType;
	/** 订单金额 */
	private String totalFee;
	/** 应结订单金额 */
	private String settlementTotalFee;
	/** 货币种类 */
	private String feeType;
	/** 现金支付金额 */
	private String cashFee;
	/** 现金支付货币类型 */
	private String cashFeeType;
	/** 代金券金额 */
	private String couponFee;
	/** 代金券使用数量 */
	private String couponCount;
	// /** 代金券类型 */
	// @JsonProperty("coupon_type_$n")
	// private String couponType$n;
	// /** 代金券ID */
	// @JsonProperty("coupon_id_$n")
	// private String couponId$n;
	// /** 单个代金券支付金额 */
	// @JsonProperty("coupon_fee_$n")
	// private String couponFee$n;
	/** 微信支付订单号 */
	private String transactionId;
	/** 商户订单号 */
	private String outTradeNo;
	/** 商家数据包 */
	private String attach;
	/** 支付完成时间 */
	private String timeEnd;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
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

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCodeDes() {
		return errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getSettlementTotalFee() {
		return settlementTotalFee;
	}

	public void setSettlementTotalFee(String settlementTotalFee) {
		this.settlementTotalFee = settlementTotalFee;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getCashFee() {
		return cashFee;
	}

	public void setCashFee(String cashFee) {
		this.cashFee = cashFee;
	}

	public String getCashFeeType() {
		return cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	public String getCouponFee() {
		return couponFee;
	}

	public void setCouponFee(String couponFee) {
		this.couponFee = couponFee;
	}

	public String getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(String couponCount) {
		this.couponCount = couponCount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
}
