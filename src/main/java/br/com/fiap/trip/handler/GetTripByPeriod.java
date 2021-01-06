package br.com.fiap.trip.handler;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import br.com.fiap.trip.dao.TripDAO;
import br.com.fiap.trip.model.HandlerRequest;
import br.com.fiap.trip.model.HandlerResponse;
import br.com.fiap.trip.model.Trip;

public class GetTripByPeriod implements RequestHandler<HandlerRequest, HandlerResponse> {
	private final TripDAO dao = new TripDAO();
	
	@Override
	public HandlerResponse handleRequest(HandlerRequest request, Context context) {

		final String topic = request.getPathParameters().get("topic");
		final String starts = request.getQueryStringParameters().get("starts");
		final String ends = request.getQueryStringParameters().get("ends");

		context.getLogger().log("Searching for registered studies for " + topic + " topic between " + starts + " and " + ends);

		final List<Trip> trips = this.dao.findByPeriod(starts, ends);
		
		if(trips == null || trips.isEmpty()) {
			return HandlerResponse.builder().setStatusCode(404).build();
		}
		
		return HandlerResponse.builder().setStatusCode(200).setObjectBody(trips).build();
	}
}
