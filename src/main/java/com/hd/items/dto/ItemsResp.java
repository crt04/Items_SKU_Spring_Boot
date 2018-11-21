package com.hd.items.dto;

/**
 * @author crt04
 *
 */
public class ItemsResp {

	int databaseUpdateCount;
	int statusCode;
	String message;

	public int getDatabaseUpdateCount() {
		return databaseUpdateCount;
	}

	public void setDatabaseUpdateCount(int databaseUpdateCount) {
		this.databaseUpdateCount = databaseUpdateCount;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
