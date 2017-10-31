package graphics.gui;

import graphics.gui.elements.Button;
import graphics.windows.Window;
import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;

public class GuiHomeManager extends GuiManager {


    public GuiHomeManager() {

    }
    protected void createGui(Window window) {
        System.out.println("createGuiHome");
        Button new_gamebutton = new Button(new Rectangle(350, 200, 100, 40), Color.black, "New Game");
        new_gamebutton.addObserver(window);
        this.elements.add(new_gamebutton);
    }
}
