package com.patternbox.promotion.hexagonal.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit test for class {@linkplain PromotionService}.
 * 
 * @author Dirk Ehms
 */
@RunWith(MockitoJUnitRunner.class)
public class PromotionServiceTest {

	@Mock
	private MessageService messageService;

	@Mock
	private CustomerRepository customerRepository;
	
	/**
	 * Setup test environment
	 */
	@Before
	public void setUp() {
	}

	@Test
	public void sendPromotion_NoMatchingCustomers_NothingSent() {
		PromotionService promotionService = new PromotionService(messageService, customerRepository);
		promotionService.sendPromotions(GameCategory.CARD_GAME);
	}
}
