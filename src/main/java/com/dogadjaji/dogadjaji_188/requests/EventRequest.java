package com.dogadjaji.dogadjaji_188.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest {
    private String name;
    private String description;
    private Date date;
    private String imgUrl;
    private Integer locationID;
    private Integer categoryID;
}
