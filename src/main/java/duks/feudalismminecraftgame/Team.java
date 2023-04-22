//bruh moment
package duks.feudalismminecraftgame;

import java.util.ArrayList;

public class Team {
    private String name;
    private int score;
    private ArrayList<Player> players = new ArrayList<Player>();

    public Team(String name){
        this.name = name;
        this.score = 0;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void removePlayer(Player player){
        players.remove(player);
    }

    public String getName(){
        return name;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    //
    public void Purchuse(){
        /*for (Player p : players){
            p.Purchuse(Cart);
        }*/
    }
}
