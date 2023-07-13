package com.boardapp.boardapi.address.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.address.model.AddressDto;
import com.boardapp.boardapi.address.service.AddressService;
import com.boardapp.boardapi.user.entity.User;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public Flux<AddressDto> findAllAddresses(){
        return this.addressService.getAllAddresses();
    }

    @GetMapping("/address:{address}")
    public Mono<AddressDto> findByAddress(@PathVariable String address){
        return this.addressService.getByAddress(address);
    }

    @GetMapping("/zipcode:{zipcode}")
    public Mono<AddressDto> findByZipcode(@PathVariable String zipcode){
        return this.addressService.getByZipcode(zipcode);
    }

    @GetMapping("/users:{address}")
    public Flux<User> findAllUser(@PathVariable String address){
        return this.addressService.getAllUserByAddress(address);
    }

    @PostMapping
    public Mono<AddressDto> saveAddress(@RequestBody Mono<AddressDto> addressDtoMono){
        return this.addressService.saveAddress(addressDtoMono);
    }

    @DeleteMapping("/:{address}")
    public Mono<Void> deleteAddress(@PathVariable String address) {
        return this.addressService.removeAddress(address);
    }
}
