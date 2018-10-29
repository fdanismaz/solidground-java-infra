package com.solidground.infra.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fdanismaz
 * date: 10/29/18 1:04 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Error {

    protected int code;
    protected String title;
    protected String message;

}
