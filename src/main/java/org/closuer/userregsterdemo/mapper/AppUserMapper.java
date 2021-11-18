package org.closuer.userregsterdemo.mapper;

import org.closuer.userregsterdemo.dto.AppUserDto;
import org.closuer.userregsterdemo.entity.AppUser;
import org.closuer.userregsterdemo.entity.Customer;
import org.closuer.userregsterdemo.entity.UserCode;
import org.closuer.userregsterdemo.model.CustomerModel;
import org.closuer.userregsterdemo.model.UserCodeModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AppUserMapper {

    public static AppUserMapper MAPPER = Mappers.getMapper(AppUserMapper.class);

    public AppUserDto appUserEntityToDto (AppUser appUser);

    public CustomerModel customerEntityToModel (Customer customer);

    public UserCodeModel userCodeEntityToModel (UserCode userCode);

    public List<AppUserDto> appUserListEntityToDto (List<AppUser> appUserList);
}
