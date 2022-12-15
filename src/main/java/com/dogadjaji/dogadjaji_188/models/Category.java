package com.dogadjaji.dogadjaji_188.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "icon")
    private String icon;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events;
}
