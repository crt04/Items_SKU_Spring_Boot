package com.hd.items.constants;

import java.util.Arrays;
import java.util.List;

public interface CommonConstants {
	public String LCP = "LCP";
	public String QA = "QA";
	public String STAGING = "STG";
	public List<String> SWAGGER_ENABLED_ENV = Arrays.asList(QA, STAGING);
}
