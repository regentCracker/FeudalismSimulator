//bruh moment
package duks.feudalismminecraftgame;

import java.util.ArrayList;

import duks.feudalismminecraftgame.Purchseables.Purchseable;
import duks.feudalismminecraftgame.Purchseables.Abilities.Abilities;

public class Player {
    private double money;
    private Team team;
    private ArrayList<Abilities> abilities = new ArrayList<Abilities>();

    public void chooseTeam(Team team){

    }

    public void Purchuse(ArrayList<Purchseable> purchseables){
        int price = 0;
        for (Purchseable p : purchseables){
            price += p.getPrice();
        }
        
    }
}
