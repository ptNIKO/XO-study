package io.hexlet.xo.model;

import io.hexlet.xo.model.Exception.AlreadyOccupiedException;
import io.hexlet.xo.model.Exception.InvalidPointException;

import java.awt.*;

public class Field {
    private static final int FIELD_SIZE = 3;

    private static final int MIN_CORDINATE = 0;

    private static final int MAX_CORDINATE = FIELD_SIZE;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize(){
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)){
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point,final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)){
            throw new InvalidPointException();
        }

        field[point.x][point.y] = figure;
    }

    private boolean checkPoint (final Point point){
        return checkCordinate(point.x) && checkCordinate(point.y);
    }

    private boolean checkCordinate(final int cordinate){
        return cordinate >= MIN_CORDINATE && cordinate < MAX_CORDINATE;
    }
}
