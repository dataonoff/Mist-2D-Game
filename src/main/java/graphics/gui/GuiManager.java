package graphics.gui;

import graphics.gui.elements.Button;
import graphics.gui.elements.GuiElement;
import graphics.windows.Window;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;

public abstract class GuiManager {

    protected List<GuiElement> elements;

    protected GuiManager() {

    }
    protected abstract void createGui(Window window);

    public void init(Window window){
        System.out.println("init Gui");
        this.elements = new ArrayList<GuiElement>();
        this.createGui(window);
        System.out.println("rend init: " + elements);
    }

    public void render(Graphics graphics){
        for (GuiElement element : elements) {
            element.draw(graphics);
        }
    }

    public void update(){
        for (GuiElement element : elements) {
            element.update();
        }
    }

    public void mouseClicked(int button, int x, int y){
        for(GuiElement element : elements)
            element.onClick(x, y);
    }
}
