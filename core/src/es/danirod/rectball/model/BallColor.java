/*
 * This file is part of Rectball.
 * Copyright (C) 2015 Dani Rodríguez.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.danirod.rectball.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Enumerated type for representing the colors balls can have. This enumared
 * type is also responsible for getting the texture region of a sheet for
 * representing that color on the screen.
 *
 * @author danirod
 */
public enum BallColor {
    // TODO: Test that the provided row and col value is right.
    BLUE(2, 0),
    GREEN(2, 1),
    RED(3, 1),
    YELLOW(3, 0),
    GRAY(1, 0);

    /**
     * Row and column value of the sprite in the sheet. Balls are expected to
     * have the same width and height, so the sheet is always a 2x2 sheet.
     */
    private int row, col;

    BallColor(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Get the texture region for representing the ball using the given color
     * using the sheet provided as source. The balls in the sheet should all
     * have the same width and height.
     *
     * @param source  source texture used to trim the region.
     * @return  the region for representing this ball.
     */
    public TextureRegion getRegion(Texture source) {
        int ball = source.getWidth() / 2;
        return new TextureRegion(source, ball * col, ball * row, ball, ball);
    }
}
