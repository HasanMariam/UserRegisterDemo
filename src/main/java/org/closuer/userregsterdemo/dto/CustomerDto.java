package org.closuer.userregsterdemo.dto;

import lombok.*;

import org.closuer.userregsterdemo.model.AppItemModel;
import org.closuer.userregsterdemo.model.AppUserModel;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    Integer id;
    String firstName;
    String lastName;
    AppUserModel appUser;
    List<AppItemModel> ownedItems;
    List<AppItemModel> requestedItems;
}
