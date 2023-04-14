package duks.feudalismminecraftgame;

import org.bukkit.Color;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private double money = 0;
    private Color color;

    public void changeMoney(double delta){
        this.money += delta;
    }
    public void changeColor(Color c) {
        this.color = c;
    }

}
