package com.dogadjaji.dogadjaji_188.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "text")
    private String text;
    @Column(name = "date")
    private String date;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "eventID")
    private Event event;
    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;
}
