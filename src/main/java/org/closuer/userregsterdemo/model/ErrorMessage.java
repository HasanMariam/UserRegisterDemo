package org.closuer.userregsterdemo.model;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    Integer errorCode;
    String errorName;
    String errorBody;

}
