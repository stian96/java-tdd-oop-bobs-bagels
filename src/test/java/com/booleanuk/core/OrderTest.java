package com.booleanuk.core;

import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.enums.CoffeeType;
import com.booleanuk.core.exceptions.FullBasketException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderTest {
    public Order order;

    @BeforeEach
    public void setUp() {
        this.order = new Order();
    }

    @Test
    public void testGetTotalReturnsDiscountOnSixBagels() throws FullBasketException {
        Basket basket = this.order.getBasket();
        basket.changeCapacity(6);

        basket.addProduct(BagelType.ONION);
        basket.addProduct(BagelType.ONION);
        basket.addProduct(BagelType.ONION);
        basket.addProduct(BagelType.ONION);
        basket.addProduct(BagelType.ONION);
        basket.addProduct(BagelType.ONION);

        double total = this.order.getTotalCost();
        Assertions.assertEquals(total, 2.49);
    }

    @Test
    public void testGetTotalReturnsDiscountOnTwelveBagels() throws FullBasketException {
        Basket basket = this.order.getBasket();
        basket.changeCapacity(12);

        basket.addProduct(BagelType.ONION);
        basket.addProduct(BagelType.ONION);
        basket.addProduct(BagelType.ONION);
        basket.addProduct(BagelType.ONION);
        basket.addProduct(BagelType.ONION);
        basket.addProduct(BagelType.ONION);

        basket.addProduct(BagelType.PLAIN);
        basket.addProduct(BagelType.PLAIN);
        basket.addProduct(BagelType.PLAIN);
        basket.addProduct(BagelType.PLAIN);
        basket.addProduct(BagelType.PLAIN);
        basket.addProduct(BagelType.PLAIN);

        double total = this.order.getTotalCost();
        Assertions.assertEquals(total, 3.99);
    }

    @Test
    public void testGetTotalReturnsDiscountOnCoffeeAndBagel() throws FullBasketException {
        Basket basket = this.order.getBasket();

        basket.addProduct(CoffeeType.BLACK);
        basket.addProduct(BagelType.SESAME);

        double total = this.order.getTotalCost();
        Assertions.assertEquals(total, 1.25);
    }
}
