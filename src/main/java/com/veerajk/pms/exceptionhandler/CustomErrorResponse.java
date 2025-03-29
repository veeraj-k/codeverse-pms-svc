package com.veerajk.pms.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorResponse {
    private HttpStatus status;
    private String message;
    private Date timestamp;

}
