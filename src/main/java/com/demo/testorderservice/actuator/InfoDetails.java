package com.demo.testorderservice.actuator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
/**
 * 
 * @author Abhinav
 *
 * adds dynamic info at the /actuator/info endpoint
 * ex: lets say active thread count in the app or number of beans
 */
@Component
public class InfoDetails implements InfoContributor {

	@Value("${info.application.name}")
	private String name;
	
	@Value("${info.application.description}")
	private String description;
	
	@Value("${info.application.version}")
	private String version;
	
	@Override
	public void contribute(Builder builder) {
		Map<String, String> appInfoMap = new HashMap<>();
		
		appInfoMap.put("name", name);
		appInfoMap.put("description", description);
		appInfoMap.put("version", version);

		builder.withDetail("application", appInfoMap);
	}

}
