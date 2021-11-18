package org.closuer.userregsterdemo.service;

import org.closuer.userregsterdemo.dto.CustomerDto;
import org.closuer.userregsterdemo.entity.Customer;
import org.closuer.userregsterdemo.exception.CustomerException;
import org.closuer.userregsterdemo.mapper.CustomerMapper;
import org.closuer.userregsterdemo.repo.CustomerRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public CustomerDto customerAdd (@NotNull Customer customer) throws CustomerException {
        if(customer.getId()!=null) throw new CustomerException("You can't add customer with ID");
        return  CustomerMapper.MAPPER.customerEntityToDto(customerRepo.save(customer));
    }

    public CustomerDto customerUpdate (@NotNull Customer customer) throws CustomerException{
        if(customer.getId()==null) throw new CustomerException("You can't update customer without ID");
        return CustomerMapper.MAPPER.customerEntityToDto(customerRepo.save(customer));
    }

    public List<CustomerDto> customerGetAll (){
        return CustomerMapper.MAPPER.customerEntityListToDto(customerRepo.findAll());
    }

    public void customerDelete(Customer customer){
        customerRepo.delete(customer);
    }

    public void customerDeleteById(Integer id){
        customerRepo.deleteById(id);
    }
}
