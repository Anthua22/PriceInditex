package com.inditex.prices.domain.exception;

import java.time.LocalDateTime;

public class PriceNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PriceNotFoundException(
            Long brandId,
            Long productId,
            LocalDateTime applicationDate) {

        super(String.format(
                "No price found for brand=%s product=%s date=%s",
                brandId,
                productId,
                applicationDate));
    }
}
