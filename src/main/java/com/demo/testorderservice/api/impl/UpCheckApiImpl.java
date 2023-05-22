package com.demo.testorderservice.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.testorderservice.api.UpCheckApiDelegate;

@Service
public class UpCheckApiImpl implements UpCheckApiDelegate {
	
	private static Logger LOG = LoggerFactory.getLogger(UpCheckApiImpl.class);
	public ResponseEntity<Map<String, String>> upCheck() {
		Map<String, String> map= new HashMap<>();
		map.put("status", "Order Service is UP!");
		if(LOG.isDebugEnabled()) {
			LOG.debug("HELLO");
		}
		LOG.info("Inside upCheck");
		return ResponseEntity.ok(map);
	}
}
