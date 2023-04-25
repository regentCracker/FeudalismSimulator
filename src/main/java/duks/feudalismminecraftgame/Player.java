package duks.feudalismminecraftgame;

import java.util.*;
import java.util.stream.Stream;

import duks.feudalismminecraftgame.Purchseables.Purchseable;
import duks.feudalismminecraftgame.Purchseables.Abilities.Abilities;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;

public class Player {
    private UUID uuid;
    private double money;
    private Party party;
    private ArrayList<Abilities> abilities = new ArrayList<Abilities>();
    private JavaPlugin plugin;

    public Player(UUID uuid, JavaPlugin plugin){//constructor
        this.plugin = plugin;
        this.uuid = uuid;
        uuidPlayerMap.put(uuid, this);//adds to the global dictionary
    }
    public void setParty(Party party){
        this.party=party;
    }
    public Party getParty(){return this.party;}
    public OfflinePlayer getPlayer(){
        try {
            return plugin.getServer().getOfflinePlayer(this.uuid);
        }catch (Exception e){
            return null;
        }
    }


    public void Purchuse(ArrayList<Purchseable> purchseables){
        int price = 0;
        for (Purchseable p : purchseables){
            price += p.getPrice();
        }
        
    }
    @Override
    public String toString(){
        return getPlayer().getName();
    }
    public static Player createFakePlayer(JavaPlugin plugin){
        Player fake = new Player(UUID.randomUUID(),plugin);

        return fake;
    }
    public static Map<UUID, Player> uuidPlayerMap = new HashMap<>();//global dictionary with all players' uuid mapped to them.
    public static Player findPlayerByUUID(UUID uuid){
        if(uuidPlayerMap.containsKey(uuid)) return uuidPlayerMap.get(uuid);
        else return null;
    }

}
