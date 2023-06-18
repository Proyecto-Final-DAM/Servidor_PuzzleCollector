package com.janicolas.CollectorServer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CollectionId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "puzzle_id")
    private Long puzzleId;
}