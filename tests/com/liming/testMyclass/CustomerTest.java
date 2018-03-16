package com.liming.testMyclass;


import org.junit.Test;
import pojo.Customer;
import pojo.Movie;
import pojo.Rental;

import org.apache.log4j.Logger;

public class CustomerTest {

    private static Logger logger = Logger.getLogger(CustomerTest.class);
    @Test
    public void statement() throws Exception {

        Customer liming = new Customer("liming");
        Movie movie = new Movie("黑豹", 1);
        Rental rental = new Rental(movie,3);
        liming.addRental(rental);
        String statement = liming.statement();
        if (logger.isDebugEnabled()){
            logger.debug(statement);
        }

    }

}
