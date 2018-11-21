package com.hd.items.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DsdatUtil {

	private static final Logger LOGGER = LogManager.getLogger(DsdatUtil.class);

	public static Timestamp getCurrentTsInET() {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		formater.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		Timestamp currTimestamp = Timestamp.valueOf(formater.format(new Date().getTime()));
		LOGGER.info("currTimestamp:::" + currTimestamp);
		return currTimestamp;
	}

}
