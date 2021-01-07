package br.com.fiap.trip.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import br.com.fiap.trip.model.Trip;

public class TripRepository {

	private static final DynamoDBMapper mapper = DynamoDBManager.mapper();
	
	public Trip save(final Trip trip) {
		mapper.save(trip);
		return trip;
	}
	
	public List<Trip> findByPeriod(final String starts, final String ends) {
	
		final Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":val1", new AttributeValue().withS(starts));
		eav.put(":val2", new AttributeValue().withS(ends));
		
		final DynamoDBQueryExpression<Trip> queryExpression = new DynamoDBQueryExpression<Trip>()
				.withKeyConditionExpression("#date between :val1 and :val2")
				.withExpressionAttributeValues(eav);
		
		final List<Trip> trips = mapper.query(Trip.class, queryExpression);
		return trips;
	}
}
