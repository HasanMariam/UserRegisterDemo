package org.closuer.userregsterdemo.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class AppUserModel {

    Integer id;
    String userName;
    String password;
    String email;
    Boolean active;
    Instant createdAt;
}
