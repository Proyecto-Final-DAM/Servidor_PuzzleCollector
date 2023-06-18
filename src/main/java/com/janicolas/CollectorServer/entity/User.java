package com.janicolas.CollectorServer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "icon")
    private String iconPath;

    @Transient
    private byte[] iconImg;

    @Column(nullable = false)
    private Boolean admin;


    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    private List<Collection> collection;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "puzzle_id"))
    private List<Puzzle> puzzles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    private List<MainEvent> mainEvents;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "user")
    private CommunityEvent communityEvent;

    //Getter Adicional
    public byte[] getIconImg() {
        String path = "src//main//resources//static/userIconImages/" + iconPath;
        try {
            return Files.readAllBytes(Path.of(path));
        } catch (IOException ignored){}
        return null;
    }
}
