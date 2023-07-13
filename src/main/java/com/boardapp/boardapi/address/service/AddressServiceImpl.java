package com.boardapp.boardapi.address.service;

import org.springframework.stereotype.Service;
import com.boardapp.boardapi.address.model.AddressDto;
import com.boardapp.boardapi.address.repository.AddressRepository;
import com.boardapp.boardapi.user.entity.User;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{
    private final AddressRepository addressRepository;

    @Override
    public Flux<AddressDto> getAllAddresses() {
        return Flux.fromIterable(this.addressRepository.findAll())
                    .map(address -> address.toDto());
    }

    @Override
    public Mono<AddressDto> getByAddress(String addressName) {
        return Mono.fromCallable(() -> this.addressRepository.findById(addressName).get())
                    .map(address -> address.toDto());
    }

    @Override
    public Mono<AddressDto> getByZipcode(String zipCode) {
        return Mono.fromCallable(() -> this.addressRepository.findByAddressZipcode(zipCode))
                    .map(address -> address.toDto());
    }

    @Override
    public Flux<User> getAllUserByAddress(String addressName) {
        return Mono.fromCallable(()-> this.addressRepository.findById(addressName).get())
                    .map(address -> address.getUserList())
                    .flatMapMany(Flux::fromIterable);
    }

    @Override
    public Mono<AddressDto> saveAddress(Mono<AddressDto> addressDtoMono) {
        return addressDtoMono.map(addressDto -> this.addressRepository.save(addressDto.toEntity()))
                                .map(address -> address.toDto());
    }

    @Override
    public Mono<Void> removeAddress(String address) {
        return Mono.fromRunnable(() -> this.addressRepository.deleteById(address));
    }

}
