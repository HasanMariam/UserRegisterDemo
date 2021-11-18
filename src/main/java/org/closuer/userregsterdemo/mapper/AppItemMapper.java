package org.closuer.userregsterdemo.mapper;

import org.closuer.userregsterdemo.dto.AppItemDto;
import org.closuer.userregsterdemo.entity.AppItem;
import org.closuer.userregsterdemo.entity.Customer;
import org.closuer.userregsterdemo.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface AppItemMapper {

    public static AppItemMapper MAPPER = Mappers.getMapper(AppItemMapper.class);

    public AppItemDto appItemEntityToDto (AppItem appItem);

    public CustomerModel customerEntityToModel(Customer customer);

    public List<AppItemDto> appItemEntityListToDto (List<AppItem> appItemList);

}
