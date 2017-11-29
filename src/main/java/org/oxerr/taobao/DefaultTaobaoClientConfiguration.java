package org.oxerr.taobao;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Initializes a {@code DefaultTaobaoClient} bean named {@code defaultTaobaoClient}.
 */
@Configuration
public class DefaultTaobaoClientConfiguration {

	private final Logger log = Logger.getLogger(getClass().getName());

	@Bean
	public DefaultTaobaoClientProperties taobaoClientProperties() {
		return new DefaultTaobaoClientProperties();
	}

	@Bean(name = "defaultTaobaoClient")
	@Autowired
	public Object taobaoClient(DefaultTaobaoClientProperties taobaoClientProperties) {
		Object taobaoClient = null;
		try {
			taobaoClient = Class.forName("com.taobao.api.DefaultTaobaoClient")
				.getConstructor(String.class, String.class, String.class,
					String.class, int.class, int.class, String.class)
				.newInstance(
					taobaoClientProperties.getServerUrl(),
					taobaoClientProperties.getAppKey(),
					taobaoClientProperties.getAppSecret(),
					taobaoClientProperties.getFormat(),
					taobaoClientProperties.getConnectTimeout(),
					taobaoClientProperties.getReadTimeout(),
					taobaoClientProperties.getSignMethod()
				);
		} catch (ClassNotFoundException | NoSuchMethodException
				| SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			log.severe(e.getMessage());
		}
		return taobaoClient;
	}

}
