package com.sanying.trust.pay.alipay.config;

public class AlipayDefaultConfig {

	// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static final String PARTNER = "2088421751343211";

	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public static final String SELLER_ID = PARTNER;

	// 签名方式
	public static final String SIGN_TYPE = "RSA";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static final String INPUT_CHARSET = "utf-8";

	// 支付类型 ，无需修改
	public static final String PAYMENT_TYPE = "1";

	// 调用的接口名，无需修改
	public static final String SERVICE = "create_direct_pay_by_user";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	// ↓↓↓↓↓↓↓↓↓↓ 请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 防钓鱼时间戳 若要使用请调用类文件submit中的query_timestamp函数
	public static final String ANTI_PHISHING_KEY = "";

	// 客户端的IP地址 非局域网的外网IP地址，如：221.0.0.1
	public static final String EXTER_INVOKE_IP = "";
	// ↑↑↑↑↑↑↑↑↑↑请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	/**
	 * 支付宝消息验证地址
	 */
	public static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

	/**
	 * 支付宝提供给商户的服务接入网关URL(新)
	 */
	public static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";

	/**
	 * 交易创建，等待买家付款
	 */
	public static final String WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
	/**
	 * 在指定时间段内未支付时关闭的交易 在交易完成全额退款成功时关闭的交易
	 */
	public static final String TRADE_CLOSED = "TRADE_CLOSED";
	/**
	 * 交易成功，且可对该交易做操作，如：多级分润、退款等
	 */
	public static final String TRADE_SUCCESS = "TRADE_SUCCESS";

	/**
	 * 等待卖家收款（买家付款后，如果卖家账号被冻结）
	 */
	public static final String TRADE_PENDING = "TRADE_PENDING";

	/**
	 * 交易成功且结束，即不可再做任何操作
	 */
	public static final String TRADE_FINISHED = "TRADE_FINISHED";

}