package br.com.fiap.trip.handler;

import java.io.IOException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.trip.config.TripRepository;
import br.com.fiap.trip.model.HandlerRequest;
import br.com.fiap.trip.model.HandlerResponse;
import br.com.fiap.trip.model.Trip;

public class CreateTrip implements RequestHandler<HandlerRequest, HandlerResponse>{

	private final TripRepository repository = new TripRepository();
	
	@Override
	public HandlerResponse handleRequest(final HandlerRequest request, final Context context) {
		Trip trip = null;
		
		try {
			trip = new ObjectMapper().readValue(request.getBody(), Trip.class);
		} catch (IOException e) {
			return HandlerResponse.builder().setStatusCode(400).setRawBody("There is a error in your Trip!").build();
		}
		context.getLogger().log("Creating a new trip " + trip.getReason());
		final Trip tripRecorded = repository.save(trip);
		return HandlerResponse.builder().setStatusCode(201).setObjectBody(tripRecorded).build();
	}

}
