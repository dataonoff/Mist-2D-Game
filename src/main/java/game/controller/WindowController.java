package game.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class WindowController {

    public abstract void init();

    public abstract void enter();

    public abstract void render(GameContainer container, Graphics graphics);

    public abstract void update(GameContainer container, int delta);

    public abstract void keyPressed(int key, char c);

    public abstract void keyReleased(int key, char c);

    public abstract float CameraFocusX();

    public abstract float CameraFocusY();
}
