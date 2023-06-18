package com.janicolas.CollectorServer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "puzzle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Puzzle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false, name = "image")
    private String imagePath;

    @Transient
    private String puzzleImg;

    @Column(nullable = false)
    private int type;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false, name = "links_path")
    private String linksPath;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.DETACH, mappedBy = "puzzles")
    private List<User> users = new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "puzzle")
    private List<Collection> collection;

    //Getters y Setters Adicionales


    public String getPuzzleImg() {
        String path = "src/main/resources/static/puzzleImages/" + imagePath;
        try {
            byte[] imageBytes = Files.readAllBytes(Path.of(path));
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException ignored) {}
        return null;
    }

    public String getLinksPath() {
        String path = "src//main//resources//static/linkFiles/" + linksPath;
        try {
            return Files.readString(Path.of(path));
        } catch (IOException ignored){}
        return null;
    }
}
