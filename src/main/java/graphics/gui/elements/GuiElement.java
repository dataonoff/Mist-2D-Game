package graphics.gui.elements;

import org.newdawn.slick.Graphics;

import java.util.Observable;

public abstract class GuiElement extends Observable {

    public abstract void draw(Graphics graphics);

    public abstract void update();

    public abstract boolean onClick(float x, float y);

}
