package duks.feudalismminecraftgame;

import duks.feudalismminecraftgame.Purchseables.Purchseable;
import jdk.internal.net.http.common.Pair;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Purchseable> inventory = new ArrayList<>();
    private List<Player> team;

    public Shop(List<Purchseable> inventory){
        this.inventory = new ArrayList<>(inventory);
    }

    public List<Purchseable> getInvetory(){
        return inventory;
    }


    public void initializePurchase(Party party){
        //initializing the purchasing in the shop
        Pair<List<Player>, List<Player>> teams = getTeams(party);//gets the fighting and buying teams.(fighters, buyers)
        MonsterFight.InitializeMonsterFight(teams.first);
        this.team = teams.second; //these are the buyers
        purchase();
    }
    public void purchase(){

    }


    public static Pair<List<Player>, List<Player>> getTeams(Party party){
        //gets the teams from this party
        return null;
    }
}
