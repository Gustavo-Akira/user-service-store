package br.com.gustavoakira.store.userservice.query;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import br.com.gustavoakira.store.core.models.PaymentDetails;
import br.com.gustavoakira.store.core.models.User;
import br.com.gustavoakira.store.core.query.FetchUserPaymentDetailsQuery;

@Component
public class UserEventsHandler {
	@QueryHandler
	public User findUserPaymentDetails(FetchUserPaymentDetailsQuery query) {
		PaymentDetails paymentDetails = PaymentDetails.builder()
				.cardNumber("123Card")
				.cvv("123")
				.name("Gustavo Akira")
				.validUntilMonth(12)
				.validUntilYear(2030)
				.build();
		
		User userRest = User.builder()
				.firstName("Gustavo")
				.lastName("Akira")
				.userId(query.getUserId())
				.details(paymentDetails)
				.build();
		return userRest;
	}
}
