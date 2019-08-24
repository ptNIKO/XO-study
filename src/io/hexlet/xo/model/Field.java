package io.hexlet.xo.model;

import io.hexlet.xo.model.Exception.InvalidPointException;

import java.awt.*;

public class Field<T> {

    private static final int MIN_CORDINATE = 0;

    private final T[][] field;

    private final int fieldSize;

    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        field = (T[][]) new Object[fieldSize][fieldSize];
    }

    public int getSize(){
        return fieldSize;
    }

    public T getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)){
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point,final T figure) throws InvalidPointException {
        if (!checkPoint(point)){
            throw new InvalidPointException();
        }

        field[point.x][point.y] = figure;
    }

    private boolean checkPoint (final Point point){
        return checkCordinate(point.x,field.length) && checkCordinate(point.y,field[point.x].length);
    }

    private boolean checkCordinate(final int cordinate,final int maxCordinate){
        return cordinate >= MIN_CORDINATE && cordinate < field.length;
    }
}
