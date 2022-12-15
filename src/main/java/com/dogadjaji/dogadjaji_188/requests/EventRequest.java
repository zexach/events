package com.dogadjaji.dogadjaji_188.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class EventRequest {
    private String name;
    private String description;
    private Date date;
    private String imgUrl;
    private Integer locationID;
    private Integer categoryID;
}
