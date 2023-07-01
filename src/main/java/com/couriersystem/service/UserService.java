package com.couriersystem.service;

import com.couriersystem.dto.request.CustomerSaveRequestDto;
import com.couriersystem.dto.request.CustomerUpdateRequestDto;
import com.couriersystem.dto.response.CustomerFindAllResponseDto;
import com.couriersystem.dto.response.CustomerFindByIdResponseDto;
import com.couriersystem.dto.response.CustomerSaveResponseDto;
import com.couriersystem.dto.response.CustomerUpdateResponseDto;
import com.couriersystem.mapper.IUserMapper;
import com.couriersystem.repository.IUserRepository;
import com.couriersystem.repository.entity.User;
import com.couriersystem.repository.entity.enums.Roles;
import com.couriersystem.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService extends ServiceManager<User,Long> {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        super(userRepository);
        this.userRepository=userRepository;
    }

    public CustomerSaveResponseDto saveCustomer(CustomerSaveRequestDto saveDto) {
        Optional<User> Opuser= userRepository.findOptionalByEmail(saveDto.getEmail());
        if(Opuser.isPresent()) {
            throw new RuntimeException("User already exists with this email: " + saveDto.getEmail());
        }
            User user = IUserMapper.INSTANCE.toUserFromCustomerSaveDto(saveDto);
            user.setRole(Roles.CUSTOMER);
            user.setEmail(saveDto.getEmail());
            user.setPassword(saveDto.getPassword());
            user.setName(saveDto.getName());
            user.setMiddleName(saveDto.getMiddleName());
            user.setLastName(saveDto.getLastName());
            user.setTC(saveDto.getTC());
            User savedUser=save(user);
            CustomerSaveResponseDto responseDto= new CustomerSaveResponseDto();
            responseDto.setId(savedUser.getId());
            responseDto.setEmail(saveDto.getEmail());

        return responseDto;
    }
    public CustomerSaveResponseDto saveCourier(CustomerSaveRequestDto saveDto) {
        Optional<User> Opuser= userRepository.findOptionalByEmail(saveDto.getEmail());
        if(Opuser.isPresent()) {
            throw new RuntimeException("User already exists with this email: " + saveDto.getEmail());
        }
        User user = IUserMapper.INSTANCE.toUserFromCustomerSaveDto(saveDto);
        user.setRole(Roles.COURIER);
        user.setEmail(saveDto.getEmail());
        user.setPassword(saveDto.getPassword());
        user.setName(saveDto.getName());
        user.setMiddleName(saveDto.getMiddleName());
        user.setLastName(saveDto.getLastName());
        user.setTC(saveDto.getTC());
        User savedUser=save(user);
        CustomerSaveResponseDto responseDto= new CustomerSaveResponseDto();
        responseDto.setId(savedUser.getId());
        responseDto.setEmail(saveDto.getEmail());

        return responseDto;
    }
    public CustomerUpdateResponseDto updateCustomer(String  customerEmail, CustomerUpdateRequestDto updateRequestDto){
        Optional<User> Opuser= userRepository.findOptionalByEmail(customerEmail);
        if(Opuser.isEmpty()){
            throw new NotFoundException("User not found with email: " + customerEmail);
        }
        Opuser.get().setPassword(updateRequestDto.getPassword());
        Opuser.get().setEmail(updateRequestDto.getEmail());
        Opuser.get().setRole(updateRequestDto.getRole());
        Opuser.get().setName(updateRequestDto.getName());
        Opuser.get().setMiddleName(updateRequestDto.getMiddleName());
        Opuser.get().setLastName(updateRequestDto.getLastName());
        Opuser.get().setTC(updateRequestDto.getTC());
        userRepository.save(Opuser.get());
        CustomerUpdateResponseDto responseDto= new CustomerUpdateResponseDto();
        responseDto.setId(Opuser.get().getId());
        responseDto.setEmail(Opuser.get().getEmail());
        return responseDto;
    }


    public List<CustomerFindAllResponseDto> findAllCustomer() {
        List<User> customer= userRepository.findAll();
        return customer.stream()
                .map(IUserMapper.INSTANCE::toCustomerFindAllResponseDto)
                .collect(Collectors.toList());
    }

    public CustomerFindByIdResponseDto findCustomerById(Long customerId) {
        Optional<User> OpUser= userRepository.findOptionalById(customerId);
        if(OpUser.isPresent()){
            User user= OpUser.get();
            return IUserMapper.INSTANCE.toCustomerFindByIdResponseDto(user);
        } else {
            throw new NotFoundException("User not found with id: " + customerId);
        }
    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new NotFoundException("User not found with id: " + id);
        }
    }
}
