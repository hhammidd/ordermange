============================
= Order Management Service =
============================
For the configuration please apply the following instructions:

0. Please create database "ordersdb" in Mysql (you can choose whatever you want) just change the
    application.properties for other names
1. The tables will create automatically
2. Please for init data insert to your Mysql database the script in resources > data.sql (just for
production and customer)
3. For orders (and orders_item) table you can use create api in controller :
For example:
                {
                "customerId":3,
                "ordersItems":[{"productionId":2,"quantity":1000}]
                }

4. After first database creation (after first running as spring boot) and inserting initial data ,
    it will highly recommend to modify auto ddl to "spring.jpa.hibernate.ddl-auto=none" , before next
    running.
5. server port is in 8090 , you can change it in application.properties
6. Please let me know for further information.
hamid.shafiekhani@mail.polimi.it
