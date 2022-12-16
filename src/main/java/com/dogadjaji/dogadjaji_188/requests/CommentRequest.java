package com.dogadjaji.dogadjaji_188.requests;

import com.dogadjaji.dogadjaji_188.models.Event;
import com.dogadjaji.dogadjaji_188.models.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {
    private String text;
    private String date;
    private Integer eventID;
    private Integer userID;
}
