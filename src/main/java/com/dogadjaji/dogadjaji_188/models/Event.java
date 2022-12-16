package com.dogadjaji.dogadjaji_188.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private Date date;
    @Column(name = "image")
    private String imgUrl;

    @ManyToOne()
    @JoinColumn(name = "locationID")
    private Location location;

    @ManyToOne()
    @JoinColumn(name = "categoryID")
    private Category category;

    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Comment> comments;
}
