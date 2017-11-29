package org.oxerr.taobao;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * DefaultTaobaoClient properties.
 */
@ConfigurationProperties(prefix = DefaultTaobaoClientProperties.PREFIX)
public class DefaultTaobaoClientProperties {

	static final String PREFIX = "com.oxerr.taobao.client";

	private String serverUrl;
	private String appKey;
	private String appSecret;
	private String format = "json";
	private String signMethod = "hmac";

	private int connectTimeout = 15000;
	private int readTimeout = 30000;

	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getSignMethod() {
		return signMethod;
	}

	public void setSignMethod(String signMethod) {
		this.signMethod = signMethod;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

}
