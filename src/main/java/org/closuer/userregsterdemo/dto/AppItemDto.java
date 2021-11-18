package org.closuer.userregsterdemo.dto;

import lombok.*;
import org.closuer.userregsterdemo.model.CustomerModel;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class AppItemDto {
    Integer id;
    String itemName;
    String itemDescription;
    CustomerModel owner;
    List<CustomerModel> requester;
}
