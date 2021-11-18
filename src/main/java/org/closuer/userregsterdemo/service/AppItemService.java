package org.closuer.userregsterdemo.service;

import org.closuer.userregsterdemo.dto.AppItemDto;
import org.closuer.userregsterdemo.entity.AppItem;
import org.closuer.userregsterdemo.mapper.AppItemMapper;
import org.closuer.userregsterdemo.repo.AppItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppItemService {

    @Autowired
    AppItemRepo appItemRepo;

    //appItemAdd
    public AppItemDto appItemAdd (AppItem appItem){
        return AppItemMapper.MAPPER.appItemEntityToDto(appItemRepo.save(appItem));
    }

    //appItemGetAll
    public List<AppItemDto> appItemGetAll (){
        return AppItemMapper.MAPPER.appItemEntityListToDto(appItemRepo.findAll());
    }

    //appItemUpdate
    public AppItemDto appItemUpdate (AppItem appItem){
        return AppItemMapper.MAPPER.appItemEntityToDto(appItemRepo.save(appItem));
    }

    //appItemDelete
    public void appItemDelete (AppItem appItem){
        appItemRepo.delete(appItem);
    }

    public void appItemDeleteByID (Integer id){
        appItemRepo.deleteById(id);
    }
}
