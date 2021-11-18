package org.closuer.userregsterdemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import org.closuer.userregsterdemo.model.CustomerModel;
import org.closuer.userregsterdemo.model.UserCodeModel;

import java.time.Instant;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto {
    Integer id;

    String userName;
    String password;
    String email;
    Boolean active;
    Instant createdAt;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    UserCodeModel userCode;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    CustomerModel customer;
}
