package com.solidground.infra.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fdanismaz
 * date: 10/29/18 1:12 PM
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidationErrorItem {

    private String itemName;
    private String message;
}
