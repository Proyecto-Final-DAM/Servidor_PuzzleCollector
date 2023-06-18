package com.janicolas.CollectorServer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "mainevent")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommunityEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private Date datePublished;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
