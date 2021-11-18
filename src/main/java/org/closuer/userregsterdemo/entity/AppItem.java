package org.closuer.userregsterdemo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppItem {

    @Id
    @GeneratedValue
    Integer id;

    String itemName;
    String itemDescription;

    @ManyToOne(targetEntity = Customer.class)
    Customer owner;

    @ManyToMany(mappedBy = "requestedItem")
    List<Customer> requester = new ArrayList<>();
}
