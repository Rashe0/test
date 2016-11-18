package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;

import java.awt.*;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	private SpriteBatch batch;
	private Texture texture;
    private Sprite sprite;
    private float posX, posY;
    private TiledMap tiledMap;
    private OrthographicCamera camera;
    private MapWithSpriteRender tiledMapRenderer;

	@Override
	public void create () {
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
        camera.update();

        texture = new Texture(Gdx.files.internal("core/assets/2.png"));
        sprite = new Sprite(texture);

        tiledMap = new TmxMapLoader().load("core/assets/FirstMap.tmx");
        tiledMapRenderer = new MapWithSpriteRender(tiledMap);
        tiledMapRenderer.addSprite(sprite);



        Gdx.input.setInputProcessor(this);
	}

	public void checkForCollision(){
        MapProperties collCheck = tiledMap.getProperties();
        if(collCheck ==){

        }
    }

    public void input (){
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            sprite.translateX(-1.2f);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            sprite.translateX(1.2f);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            sprite.translateY(1.2f);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            sprite.translateY(-1.2f);
        }
    }


	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        input();
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
	}
	
	@Override
	public void dispose () {
        texture.dispose();
        tiledMapRenderer.dispose();
        tiledMap.dispose();
	}

	@Override
    public void resize(int width, int height){

    }

    @Override
    public void pause(){

    }

    @Override
    public void resume(){

    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.LEFT)
            camera.translate(-32,0);
        if(keycode == Input.Keys.RIGHT)
            camera.translate(32,0);
        if(keycode == Input.Keys.UP)
            camera.translate(0,-32);
        if(keycode == Input.Keys.DOWN)
            camera.translate(0,32);
        if(keycode == Input.Keys.NUM_1)
            tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
        if(keycode == Input.Keys.NUM_2)
            tiledMap.getLayers().get(1).setVisible(!tiledMap.getLayers().get(1).isVisible());
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
