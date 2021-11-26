package org.closuer.userregsterdemo.controller;

import org.closuer.userregsterdemo.entity.AppUser;
import org.closuer.userregsterdemo.exception.AppUserException;
import org.closuer.userregsterdemo.model.ErrorMessage;
import org.closuer.userregsterdemo.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @PostMapping(value = "/add")
    public ResponseEntity<Object> appUserAdd (@RequestBody AppUser appUser) throws AppUserException {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(appUserService.appUserAdd(appUser));
        }
        catch (AppUserException e){
            ErrorMessage errorMessage= new ErrorMessage().withErrorBody(e.getMessage()).withErrorCode(1).withErrorName("USER_ADD_ERROR");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }

    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<Object> appUserGetAll(){
        return ResponseEntity.status(HttpStatus.OK).body(appUserService.appUserGetAll());
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Object> appUserUpdate(@RequestBody AppUser appUser) throws AppUserException {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(appUserService.appUserUpdate(appUser));
        } catch (AppUserException e) {
            ErrorMessage errorMessage = new ErrorMessage().withErrorBody(e.getMessage()).withErrorCode(2).withErrorName("USER_UPDATE_ERROR");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @DeleteMapping(value = "/delete")
    public void appUserDelete(@RequestBody AppUser appUser){
        appUserService.appUserDelete(appUser);
    }

    @DeleteMapping(value ="delete/{id}")
    public void appUserDeleteById(@PathVariable Integer id){
        appUserService.appUserDeleteByID(id);
    }

    @PostMapping(value = "/auth")
    public ResponseEntity<Object> appUserAuth(@RequestBody AppUser appUser) throws AppUserException{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(appUserService.appUserAuth(appUser));
        }
        catch (AppUserException e){
            ErrorMessage errorMessage = new ErrorMessage().withErrorBody(e.getMessage()).withErrorCode(3).withErrorName("USER_AUTH_ERROR");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorMessage);
        }
    }

    @PutMapping(value = "/verify")
    public ResponseEntity<Object> appUserVerify(@RequestParam Integer id, @RequestParam Integer userCode) throws AppUserException{
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(appUserService.appUserVerify(id,userCode));
        }
        catch (AppUserException e){
            ErrorMessage errorMessage = new ErrorMessage().withErrorBody(e.getMessage()).withErrorCode(4).withErrorName("USER_VERIFY_ERROR");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorMessage);
        }
    }

    @GetMapping(value = "/search/{attributeName}")
    public List<AppUser> testSearch(@PathVariable String attributeName, @RequestParam Object text){
      return   appUserService.appUserSearchTest(attributeName,text);
    }
}
