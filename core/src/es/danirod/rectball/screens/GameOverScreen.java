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
package es.danirod.rectball.screens;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;
import es.danirod.rectball.Constants;
import es.danirod.rectball.RectballGame;
<<<<<<< HEAD
import es.danirod.rectball.actors.Value;
import es.danirod.rectball.settings.ScoreIO;
import es.danirod.rectball.statistics.Statistics;
import es.danirod.rectball.utils.SoundPlayer.SoundCode;

public class GameOverScreen extends MenuScreen {

    private Label aliveTime;

    private Label highScore;
    private Value score;
=======
import es.danirod.rectball.listeners.ScreenJumper;

public class GameOverScreen extends AbstractScreen {
>>>>>>> feature/refactor

    public GameOverScreen(RectballGame game) {
        super(game);
    }

    @Override
    public void setUpInterface(Table table) {
<<<<<<< HEAD
        Label gameOver = newLabel("GAME OVER");
        aliveTime = newLabel("Alive: " + (int) game.aliveTime + " s");
        highScore = newLabel("High Score: " + game.scores.getHighestScore());

        Texture sheet = game.manager.get("scores.png", Texture.class);
        score = new Value(sheet, 4, game.scores.getLastScore());
        table.add(score).pad(40).colspan(2).fillX().height(200).row();

        table.add(gameOver).pad(40).colspan(2).expandX().expandY().align(Align.center).row();
        table.add(aliveTime).pad(20).colspan(2).expandX().expandY().align(Align.center).row();
        table.add(highScore).pad(20).colspan(2).expandX().expandY().align(Align.center).row();

        TextButton replay = newButton("Replay");
        TextButton menu = newButton("Menu");
        table.add(replay).pad(40).expandX().height(100);
        table.add(menu).pad(40).expandX().height(100).row();

        replay.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.player.playSound(SoundCode.SUCCESS);
                game.setScreen(Screens.GAME);
            }
        });
        menu.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.player.playSound(SoundCode.FAIL);
                game.setScreen(Screens.MAIN_MENU);
            }
        });
    }

    @Override
    public void show() {
        super.show();

        aliveTime.setText("Alive: " + (int) game.aliveTime + " s");
        highScore.setText("High Score: " + game.scores.getHighestScore());
        score.setValue(game.scores.getLastScore());

        game.statistics.getTotalData().incrementValue("games");
        game.statistics.getTotalData().incrementValue("time", (int) game.aliveTime);
        ScoreIO.save(game.scores);
        Statistics.saveStats(game.statistics);
=======
        // Set up the label data.
        String lastScore = Integer.toString(game.getState().getScore());
        while (lastScore.length() < 4)
            lastScore = "0" + lastScore;
        String aliveTime = Integer.toString(Math.round(game.getState().getTime()));
        String highScore = Long.toString(game.scores.getHighestScore());

        // Last score.
        Label highScoreLabel = new Label(lastScore, game.getSkin(), "monospace");
        highScoreLabel.setFontScale(10f);
        table.add(new Label(game.getLocale().get("game.gameover"), game.getSkin())).colspan(2).expandX().row();
        table.add(highScoreLabel).expand().colspan(2).align(Align.center).row();

        // Alive time.
        Drawable clock = game.getSkin().newDrawable("iconClock");
        table.add(new Image(clock)).size(80).expandX().align(Align.right).padRight(20);
        table.add(new Label(aliveTime, game.getSkin())).expandX().align(Align.left).padLeft(20).row();

        // High score.
        Drawable crown = game.getSkin().newDrawable("iconCrown");
        table.add(new Image(crown)).size(80).expandX().align(Align.right).padRight(20);
        table.add(new Label(highScore, game.getSkin())).expandX().align(Align.left).padLeft(20).row();

        // Add replay button.
        TextButton replay = new TextButton(game.getLocale().get("game.replay"), game.getSkin());
        replay.addCaptureListener(new ScreenJumper(game, Screens.GAME));
        table.add(replay).colspan(2).fillX().height(100).padTop(30).row();

        // Add menu button.
        TextButton menu = new TextButton(game.getLocale().get("game.menu"), game.getSkin());
        menu.addCaptureListener(new ScreenJumper(game, Screens.MAIN_MENU));
        table.add(menu).colspan(2).fillX().height(100).padTop(30).row();

        // Now animate the stage to make it fall.
        getStage().addAction(Actions.sequence(
                Actions.moveBy(0, Constants.VIEWPORT_HEIGHT),
                Actions.moveBy(0, -Constants.VIEWPORT_HEIGHT, 0.25f)
        ));
>>>>>>> feature/refactor
    }

    @Override
    public int getID() {
        return Screens.GAME_OVER;
    }



}
