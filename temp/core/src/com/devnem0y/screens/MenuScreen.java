package com.devnem0y.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.devnem0y.Application;
import com.devnem0y.managers.GameScreenManager;

import static com.devnem0y.utils.Constants.APP_HEIGHT;

public class MenuScreen extends AbstractScreen{

    public MenuScreen(final Application app) {
        super(app);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("MENU");
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            app.gsm.setScreen(GameScreenManager.STATE.GAME);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        app.batch.begin();
		fontLog.draw(app.batch, "press Q to the GameScreen", 10, APP_HEIGHT - 10);
        app.batch.end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
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
