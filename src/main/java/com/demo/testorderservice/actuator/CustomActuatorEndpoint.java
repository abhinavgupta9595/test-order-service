/**
 * 
 */
package com.demo.testorderservice.actuator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

/**
 * @author Abhinav
 *
 * Class to generate a custom endpoint for Actuator
 * below we create /releaseNotes endpoint to have relevant details
 */
@Component
@Endpoint(id = "releaseNotes")
public class CustomActuatorEndpoint {

	Map<String, List<String>> map = new HashMap<>();
	
	@PostConstruct
	public void initNotes() {
		map.put("version-1.0", Arrays.asList("one", "two","three"));
		map.put("version-2.0", Arrays.asList("one", "two","three"));
	}
	
	/**
	 * 
	 * @return
	 * get release notes. ex /actuator/releaseNotes
	 * @ReadOperation annotation denotes GET mapping. for POST use @WriteOperation
	 */
	@ReadOperation
	public Map<String, List<String>> getReleaseNotes(){
		return map;
	}
	
	/**
	 * 
	 * @param version
	 * @return
	 * get release notes by some version. ex /actuator/releaseNotes/version-1.0
	 */
	@ReadOperation
	public List<String> getReleaseNotesByVersion(@Selector String version){
		return map.get(version);
	}
}
