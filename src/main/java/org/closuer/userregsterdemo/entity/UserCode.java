package org.closuer.userregsterdemo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UserCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Integer code;

}
