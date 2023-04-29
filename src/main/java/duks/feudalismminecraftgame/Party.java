package duks.feudalismminecraftgame;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public class Party {
    private static ArrayList<Party> Parties = new ArrayList<Party>();
    private int UUID = 0;
    private int score;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<java.util.UUID> inviteeList = new ArrayList<java.util.UUID>();
    private JavaPlugin plugin;

    public static int counterCreated = 0;
    
    public Party(JavaPlugin plugin){
        this.plugin = plugin;
        this.UUID = counterCreated;
        counterCreated++;
        this.score = 0;
    }

    @Override
    public String toString(){
        return this.getMembers().toString();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    private void removePlayer(Player player){
        players.remove(player);
    }

    public int getUUID(){
        return UUID;
    }

    public ArrayList<Player> getMembers(){
        return players;
    }

    public ArrayList<java.util.UUID> getInviteeList(){
        return inviteeList;
    }
    
    public void echo(String message){
        for (Player p : players){
            if(p.getPlayer().isOnline()){
                ((org.bukkit.entity.Player)p.getPlayer()).sendMessage(message);
            }
        }
    }

    public void Purchuse(){
        /*for (Player p : players){
            p.Purchuse(Cart);
        }*/
    }

    //run when the plugin begins
    static public void init(){
    }

    static public void addInvitee(UUID playerUUID, Party party){
        party.inviteeList.add(playerUUID);
    }

    //to create a new party use party=null
    static public void addPlayerToParty(duks.feudalismminecraftgame.Player player, Party party, JavaPlugin plugin){
        if(party!=null) {
            party.addPlayer(player);
            player.setParty(party);
        }else {
            Party p = new Party(plugin);
            p.addPlayer(player);
            player.setParty(p);
            Parties.add(p);
        }
    }

    static public void removePlayerFromParty(duks.feudalismminecraftgame.Player player, JavaPlugin plugin){
        Party party = player.getParty();
        ArrayList<Player> members = party.getMembers();

        if(members.size()==1) {
            return;
        }

        player.getParty().removePlayer(player);
        addPlayerToParty(player, null, plugin);
    }
}

