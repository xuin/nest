package com.sanying.trust.pay.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRequest {

	private static RequestConfig DEFAULT_REQUEST_CONFIG = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(3000).build();

	private static CloseableHttpClient HTTP_CLIENT = HttpClients.custom().setDefaultRequestConfig(DEFAULT_REQUEST_CONFIG).build();

	private static Logger LOGGER = LoggerFactory.getLogger(HttpRequest.class);

	public static String post(String url, String body) throws ClientProtocolException, IOException {
		// HttpClient
		HttpPost httpPost = new HttpPost(url);
		StringEntity postEntity = new StringEntity(body, "UTF-8");
		httpPost.addHeader("Content-Type", "text/xml");
		httpPost.setEntity(postEntity);
		System.out.println(httpPost.getRequestLine());
		LOGGER.debug("发送请求(HttpClient) - {}", body);
		try {
			HttpResponse response = HTTP_CLIENT.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity, "UTF-8");
			LOGGER.debug("获取响应(HttpClient) - {}", result);
			return result;
		} finally {
			httpPost.abort();
		}
	}
}
