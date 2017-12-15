package graphics.gui.elements;

import javafx.util.Pair;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import java.util.Observable;

public class Button extends GuiElement {

    private Rectangle rectangle;
    private Color color;
    private String buttontext;

    public Button(Rectangle rectangle, Color color, String buttontext) {
        this.rectangle = rectangle;
        this.color = color;
        this.buttontext = buttontext;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fill(rectangle);
        graphics.setColor(Color.white);
        graphics.drawString(buttontext, rectangle.getX() + 10,rectangle.getY()+10);
    }

    public void update() {

    }

    public boolean onClick(float x, float y) {
        if (this.rectangle.contains(x, y)) {
            this.setChanged();
            this.notifyObservers(new Pair<String, Integer>("redirect", 1));
            return true;
        }
        return false;
    }
}
