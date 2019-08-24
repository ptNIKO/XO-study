package io.hexlet.xo.model;

import io.hexlet.xo.model.Exception.AlreadyOccupiedException;
import io.hexlet.xo.model.Exception.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {
        final Field<Figure> field = new Field<>(3);

        assertEquals(3,field.getSize());
    }

    @Test
    public void setFigure() throws AlreadyOccupiedException, InvalidPointException {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure =  Figure.O;

        field.setFigure(inputPoint,inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure,actualFigure);

    }

    @Test
    public void getFigureWhenFigureIsNotSet() throws AlreadyOccupiedException, InvalidPointException {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(0,0);


        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);

    }

    @Test
    public void getFigureWhenXIsLessThenZero() throws AlreadyOccupiedException, InvalidPointException {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(-1,0);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        }catch (final InvalidPointException e){}
    }

    @Test
    public void getFigureWhenYIsLessThenZero() throws AlreadyOccupiedException, InvalidPointException {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(0,-1);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        }catch (final InvalidPointException e){}
    }


    @Test
    public void getFigureWhenXIsMoreThenSize() throws AlreadyOccupiedException, InvalidPointException {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(field.getSize() + 1,0);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        }catch (final InvalidPointException e){}
    }

    @Test
    public void getFigureWhenYIsMoreThenSize() throws AlreadyOccupiedException, InvalidPointException {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(0,field.getSize() + 1);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        }catch (final InvalidPointException e){}
    }
}