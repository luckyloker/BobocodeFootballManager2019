package com.bobocode.util;

import com.bobocode.model.Player;
import com.bobocode.model.Position;
import com.bobocode.model.Team;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataGenerator {
    // todo: build normal dataGenerator
    public static Team teamGenerator() {
        return Team.builder()
                .name(teamNameGenerator())
                .build();
    }

    private static String teamNameGenerator() {
        String[] teamNames = {"Liverpool", "Leeds", "Millwall", "Derby County", "Nottingham Forest"};
        return teamNames[ThreadLocalRandom.current().nextInt(5)];
    }

    public static List<Team> teamListGenerator() {
        return IntStream.rangeClosed(1,5)
                .mapToObj(i -> DataGenerator.teamGenerator())
                .collect(Collectors.toList());
    }

    public static Player playerGenerator() {
        return Player.builder()
                .firstName(playerFirstName())
                .lastName(playerLastName())
                .position(playerRandomPosition())
                .build();
    }

    private static Position playerRandomPosition() {
        return Position.MIDFIELDER;
    }

    private static String playerFirstName() {
        String[] playersFirstNames = {"Bob", "Mark", "Steve", "Paul", "Andrew"};
        return playersFirstNames[ThreadLocalRandom.current().nextInt(5)];
    }

    private static String playerLastName() {
        String[] playersFirstNames = {"Rooney", "Kane", "Salah", "Milner", "Firmino"};
        return playersFirstNames[ThreadLocalRandom.current().nextInt(5)];
    }


}
