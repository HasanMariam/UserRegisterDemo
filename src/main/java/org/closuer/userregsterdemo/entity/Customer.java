package org.closuer.userregsterdemo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    Integer id;

    String firstName;
    String lastName;

    @JoinColumn(nullable = false)
    @OneToOne(cascade = CascadeType.ALL, optional = false, targetEntity = AppUser.class, orphanRemoval = true)
    AppUser appUser;

    @OneToMany(mappedBy = "owner")
    List<AppItem> ownedItems = new ArrayList<>();

    @JoinTable(name = "app_item_requester",
            joinColumns = @JoinColumn(name = "requester_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    @ManyToMany
    List<AppItem> requestedItem = new ArrayList<>();
}
