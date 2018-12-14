package com.bobocode.model;


import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@ToString
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

//    @Column(name = "captain")
//    private Player captain;  //todo: guess how to map captain.

    @Setter(AccessLevel.PRIVATE)
    @Builder.Default
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
        player.setTeam(this);
    }

    public void removePlayer(Player player) {
        players.remove(player);
        player.setTeam(null);
    }
}
