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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Tag(name = "RESTful API Guide for Addresses", description = "주소 정보 관련 CRD")
@RestController
@RequestMapping("addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @Operation(summary = "Find all addresses", description = "등록된 모든 주소목록을 조회합니다.")
    @GetMapping
    public Flux<AddressDto> findAllAddresses() {
        return this.addressService.getAllAddresses();
    }

    @Operation(summary = "Find specific address by address name", description = "등록된 특정 주소 정보를 주소이름으로 검색합니다.")
    @GetMapping("/address:{address}")
    public Mono<AddressDto> findByAddress(@PathVariable String address) {
        return this.addressService.getByAddress(address);
    }

    @Operation(summary = "Find specific address by address zipcode", description = "등록된 특정 주소 정보를 주소ZipCode로 검색합니다.")
    @GetMapping("/zipcode:{zipcode}")
    public Mono<AddressDto> findByZipcode(@PathVariable String zipcode) {
        return this.addressService.getByZipcode(zipcode);
    }

    @Operation(summary = "Find all users within specific address", description = "특정 주소로 등록된 모든 사용자 세부정보를 조회합니다.")
    @GetMapping("/users:{address}")
    public Flux<User> findAllUser(@PathVariable String address) {
        return this.addressService.getAllUserByAddress(address);
    }

    @Operation(summary = "Address information enrollment", description = "주소 정보를 등록합니다.")
    @PostMapping
    public Mono<AddressDto> saveAddress(@RequestBody Mono<AddressDto> addressDtoMono) {
        return this.addressService.saveAddress(addressDtoMono);
    }

    @Operation(summary = "Delete specific address information", description = "특정 주소 정보를 삭제합니다.")
    @DeleteMapping("/:{address}")
    public Mono<Void> deleteAddress(@PathVariable String address) {
        return this.addressService.removeAddress(address);
    }
}
