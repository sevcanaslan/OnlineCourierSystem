package com.couriersystem.controller;

import com.couriersystem.dto.request.CustomerSaveRequestDto;
import com.couriersystem.dto.request.CustomerUpdateRequestDto;
import com.couriersystem.dto.response.CustomerFindAllResponseDto;
import com.couriersystem.dto.response.CustomerFindByIdResponseDto;
import com.couriersystem.dto.response.CustomerSaveResponseDto;
import com.couriersystem.dto.response.CustomerUpdateResponseDto;
import com.couriersystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.couriersystem.constants.EndPoints.*;
@RequestMapping(USER)
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

//        POST /users: Yeni bir kullanıcı oluştur.
//        GET /users: Tüm kullanıcıları listele.
//        GET /users/{userId}: Belirli bir kullanıcının bilgilerini getir.
//        PUT /users/{userId}: Belirli bir kullanıcının bilgilerini güncelle.
//        DELETE /users/{userId}: Belirli bir kullanıcıyı sil.


    @PostMapping(SAVECUSTOMER)
    //Customer kaydeden method
    ResponseEntity<CustomerSaveResponseDto> saveCustomer(@RequestBody CustomerSaveRequestDto saveDto){
    return ResponseEntity.ok(userService.saveCustomer(saveDto));
    }


    @PostMapping(SAVECOURIER)
        //Customer kaydeden method
    ResponseEntity<CustomerSaveResponseDto> saveCourier(@RequestBody CustomerSaveRequestDto saveDto){
        return ResponseEntity.ok(userService.saveCourier(saveDto));
    }

    @GetMapping(FINDALL)
    ResponseEntity<List<CustomerFindAllResponseDto>> findAllCustomer(){
        return ResponseEntity.ok(userService.findAllCustomer());
    }

    @GetMapping("/{customerId}")
    ResponseEntity<CustomerFindByIdResponseDto> findCustomerById(@PathVariable("customerId") Long customerId){
        return ResponseEntity.ok(userService.findCustomerById(customerId));
    }

    @PutMapping("/update/{customerEmail}")
    ResponseEntity<CustomerUpdateResponseDto> updateCustomer(@PathVariable("customerEmail")String customerEmail, @RequestBody CustomerUpdateRequestDto updateRequestDto){
        return ResponseEntity.ok(userService.updateCustomer(customerEmail, updateRequestDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
