package io.hexlet.xo.model;


public class Game<F> {

    private final String name;

    private final Player[] players;

    private final Field<F> field;

    public Game(final String name,
                final Player[] players,
                final Field<F> field) {
        this.name = name;
        this.players = players;
        this.field = field;//Test
    }

    public Player[] getPlayers(){
        return players;
    }

    public Field<F> getField(){
        return field;
    }

    public String getName(){
        return name;
    }
}
