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

import java.util.Base64;
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
    private String iconImg;

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

    //Getter y Setter Adicionales

    public String getIconImg() {
        Path path = Path.of("src//main//resources//static/userIconImages/" + iconPath);
        try {
            byte[] imageBytes = Files.readAllBytes(path);
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException ignored){}
        return null;
    }

    public void setIconImg(String iconImg) {
        Path path = Path.of("src//main//resources//static/userIconImages/" + iconPath);
        if(iconImg.equals("null")){
            if(path.toFile().exists()){
                path.toFile().delete();
            }
        } else {
            try {
                byte[] img = Base64.getMimeDecoder().decode(iconImg);
                Files.write(path, img);
            } catch (IOException ignored){}
        }
    }
}
