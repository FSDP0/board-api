package com.boardapp.boardapi.address.service;

import com.boardapp.boardapi.address.model.AddressDto;
import com.boardapp.boardapi.user.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AddressService {
    Flux<AddressDto> getAllAddresses();

    Mono<AddressDto> getByAddress(String address);

    Mono<AddressDto> getByZipcode(String zipCode);

    Flux<User> getAllUserByAddress(String address);

    Mono<AddressDto> saveAddress(Mono<AddressDto> addressDtoMono);

    Mono<Void> removeAddress(String address);
}
