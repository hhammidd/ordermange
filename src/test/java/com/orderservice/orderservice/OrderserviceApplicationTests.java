package com.orderservice.orderservice;

import com.orderservice.orderservice.model.Product;
import com.orderservice.orderservice.model.dao.CustomerRepository;
import com.orderservice.orderservice.model.dao.OrderRepository;
import com.orderservice.orderservice.model.dao.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = OrderserviceApplication.class)
public class OrderserviceApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Test
    @Sql({"/clear-tables.sql","/populate-tables.sql"})
    @Transactional
	public void contextLoads() {
	}

}
