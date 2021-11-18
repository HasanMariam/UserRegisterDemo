package org.closuer.userregsterdemo.service;


import org.closuer.userregsterdemo.dto.AppUserDto;
import org.closuer.userregsterdemo.entity.AppUser;
import org.closuer.userregsterdemo.entity.UserCode;
import org.closuer.userregsterdemo.exception.AppUserException;
import org.closuer.userregsterdemo.mapper.AppUserMapper;
import org.closuer.userregsterdemo.repo.AppUserRepo;
import org.closuer.userregsterdemo.repo.UserCodeRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class AppUserService {

    @Autowired
    AppUserRepo appUserRepo;

    @Autowired
    MailService mailService;

    @Autowired
    UserCodeRepo userCodeRepo;

    public void appUserDelete(AppUser appUser){
        appUserRepo.delete(appUser);
    }

    public void appUserDeleteByID (Integer id){
        appUserRepo.deleteById(id);
    }

    public AppUserDto appUserAdd (@NotNull AppUser appUser)throws AppUserException {
        if(appUser.getId()!=null) throw new AppUserException("You can't add AppUser With ID");
        if(appUserRepo.findByEmail(appUser.getEmail()).isPresent()) throw new AppUserException("Email already existed");
        int verifyCode= (int) (Math.random()*10000);
        mailService.newAppUserMail(appUser.getEmail(),"verify your account","use this code to verify your account : "+verifyCode);
        AppUser newAppUser = appUserRepo.save(appUser.withActive(false).withCreatedAt(Instant.now()));
        UserCode userCode= userCodeRepo.save(new UserCode().withCode(verifyCode));
         return AppUserMapper.MAPPER.appUserEntityToDto(appUserRepo.save(newAppUser.withUserCode(userCode)));

    }

    public List<AppUserDto> appUserGetAll(){
       return AppUserMapper.MAPPER.appUserListEntityToDto(appUserRepo.findAll());
    }

    public AppUserDto appUserUpdate(@NotNull AppUser appUser) throws AppUserException{
        if(appUser.getId()==null) throw new AppUserException("You can't update AppUser Without ID");
        return AppUserMapper.MAPPER.appUserEntityToDto(appUserRepo.save(appUser)) ;
    }

    public AppUserDto appUserAuth( @NotNull AppUser appUser) throws AppUserException{
        return AppUserMapper.MAPPER.appUserEntityToDto(appUserRepo.findByUserNameAndPassword(appUser.getUserName(),appUser.getPassword()).orElseThrow(()->new AppUserException("no such user in DB")));
    }

    public boolean appUserVerify (Integer id , Integer userCode) throws AppUserException{
        AppUser appUser = appUserRepo.findById(id).orElseThrow(()->new AppUserException("no such user in DB"));
        if (userCode.equals(appUser.getUserCode().getCode()))
        {
            appUserUpdate(appUser.withActive(true).withUserCode(null));
          return true;}
        else return false;

    }
}
