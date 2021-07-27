package br.com.gustavoakira.store.userservice.query.rest;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavoakira.store.core.models.User;
import br.com.gustavoakira.store.core.query.FetchUserPaymentDetailsQuery;

@RestController
@RequestMapping("/users")
public class UsersQueryController {
	@Autowired
	QueryGateway gateway;
	
	@GetMapping("/{userId}/payment-details")
	public User getUserPaymentDetails(@PathVariable String userId) {
		FetchUserPaymentDetailsQuery query = new FetchUserPaymentDetailsQuery(userId);
		return gateway.query(query, ResponseTypes.instanceOf(User.class)).join();
	}
}
