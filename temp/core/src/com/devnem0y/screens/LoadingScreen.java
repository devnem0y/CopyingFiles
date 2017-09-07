package com.devnem0y.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.devnem0y.Application;
import com.devnem0y.managers.GameScreenManager;

import static com.devnem0y.utils.Constants.APP_SCREEN_HEIGHT;
import static com.devnem0y.utils.Constants.APP_SCREEN_WIDTH;

public class LoadingScreen extends AbstractScreen{

    private float midY;
    private ShapeRenderer shapeRenderer;
    private float progress;

    public LoadingScreen(final Application app) {
        super(app);
        this.shapeRenderer = new ShapeRenderer();
        midY = APP_SCREEN_HEIGHT / 2;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("LOADING");
        this.progress = 0f;
        queueAssets();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        progress = MathUtils.lerp(progress, app.assetManager.getProgress(), 0.1f);
        if (app.assetManager.update() && progress >= app.assetManager.getProgress() - 0.001f) {
            app.gsm.setScreen(GameScreenManager.STATE.SPLASH);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(32, midY - 8, APP_SCREEN_WIDTH - 64, 16);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(32, midY - 8, progress * (APP_SCREEN_WIDTH - 64), 16);
        shapeRenderer.end();
        stage.draw();
    }

    private void queueAssets() {
		app.assetManager.load("logo.png", Texture.class);
        app.assetManager.finishLoading();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        shapeRenderer.dispose();
    }
}
