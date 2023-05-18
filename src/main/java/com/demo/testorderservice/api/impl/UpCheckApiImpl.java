package com.demo.testorderservice.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.testorderservice.api.UpCheckApiDelegate;

@Service
public class UpCheckApiImpl implements UpCheckApiDelegate {

	public ResponseEntity<Map<String, String>> upCheck() {
		Map<String, String> map= new HashMap<>();
		map.put("status", "Order Service is UP!");
		return ResponseEntity.ok(map);
	}
}
