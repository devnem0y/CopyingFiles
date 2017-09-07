package com.devnem0y.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.devnem0y.Application;
import com.devnem0y.managers.GameScreenManager;

import static com.devnem0y.utils.Constants.*;

public class GameScreen extends AbstractScreen{

    public GameScreen(final Application app) {
        super(app);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("GAME");
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)) {
            app.gsm.setScreen(GameScreenManager.STATE.MENU);
        }else if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        app.batch.begin();
        fontLog.draw(app.batch, "press BACKSPACE return MenuScreen", 10, APP_HEIGHT - 10);
        fontLog.draw(app.batch, "press ESC to the exit", 10, APP_HEIGHT - 25);
        app.batch.end();
        stage.draw();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
