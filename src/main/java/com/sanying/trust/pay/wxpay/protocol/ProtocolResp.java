package com.sanying.trust.pay.wxpay.protocol;

public class ProtocolResp extends ProtocolBase {
	private static final long serialVersionUID = 8930630564621465526L;
	/** 返回状态码 */
	private String returnCode;
	/** 返回信息 */
	private String returnMsg;

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
}
