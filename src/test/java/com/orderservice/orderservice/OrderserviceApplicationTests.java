package com.orderservice.orderservice;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = OrderserviceApplication.class)
public class OrderserviceApplicationTests {


	@Test
    @Sql({"/clear-tables.sql","/populate-tables.sql"})
    @Transactional
	public void contextLoads() {
	}

}
