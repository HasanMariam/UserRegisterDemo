package org.closuer.userregsterdemo.mapper;

import org.closuer.userregsterdemo.dto.CustomerDto;
import org.closuer.userregsterdemo.entity.AppItem;
import org.closuer.userregsterdemo.entity.AppUser;
import org.closuer.userregsterdemo.entity.Customer;
import org.closuer.userregsterdemo.model.AppItemModel;
import org.closuer.userregsterdemo.model.AppUserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {
    public static CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    public CustomerDto customerEntityToDto (Customer customer);

    public AppUserModel appUserEntityToModel(AppUser appUser);

    public AppItemModel appItemEntityToModel(AppItem appItem);

    public List<CustomerDto> customerEntityListToDto (List<Customer> customerList);
}
