package org.closuer.userregsterdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;


    @Column(unique = true)
    String userName;
    String password;
    @Column(nullable = false)
    String email;
    Boolean active;
    @Column(updatable = false)
    @JsonIgnore
    Instant createdAt;


    @OneToOne(cascade = CascadeType.ALL, targetEntity = UserCode.class,orphanRemoval = true)
    UserCode userCode;

}
