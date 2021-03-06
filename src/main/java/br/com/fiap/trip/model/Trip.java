package br.com.fiap.trip.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "trip")
public class Trip {

	@DynamoDBHashKey(attributeName = "id")
	@DynamoDBAutoGeneratedKey
	private String id;
	
	private String country;

	private String city;
	
	private String date;
	
	private String reason;
	
	public Trip(String id, String country, String city, String date, String reason) {
		super();
		this.id = id;
		this.country = country;
		this.city = city;
		this.date = date;
		this.reason = reason;
	}
	
	public Trip() {
		super();
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
