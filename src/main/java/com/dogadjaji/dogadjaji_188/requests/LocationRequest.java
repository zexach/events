package com.dogadjaji.dogadjaji_188.requests;

import com.dogadjaji.dogadjaji_188.models.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationRequest {
    private String name;
    private String description;
    private String image;
}
