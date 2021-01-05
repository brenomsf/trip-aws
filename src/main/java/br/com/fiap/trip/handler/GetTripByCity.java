package br.com.fiap.trip.handler;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import br.com.fiap.trip.dao.TripDAO;
import br.com.fiap.trip.model.HandlerRequest;
import br.com.fiap.trip.model.HandlerResponse;
import br.com.fiap.trip.model.Trip;

public class GetTripByCity implements RequestHandler<HandlerRequest, HandlerResponse>{

	private final TripDAO dao = new TripDAO();

	@Override
	public HandlerResponse handleRequest(HandlerRequest request, Context context) {

		final String city = request.getPathParameters().get("city");

		context.getLogger()
				.log("Searching trips for city" + city);
		final List<Trip> trips = this.dao.findByCity(city);

		if (city == null || city.isEmpty()) {
			return HandlerResponse.builder().setStatusCode(404).build();
		}

		return HandlerResponse.builder().setStatusCode(200).setObjectBody(trips).build();
	}
}
