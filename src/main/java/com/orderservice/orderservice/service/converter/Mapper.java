package com.orderservice.orderservice.service.converter;

public interface Mapper<DOMAIN, TO> {

    TO convertToDto(DOMAIN domain);

    DOMAIN convertToDomain(TO to);
}
