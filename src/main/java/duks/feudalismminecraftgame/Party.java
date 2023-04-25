package duks.feudalismminecraftgame;

import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Party {
    private static ArrayList<Party> Parties = new ArrayList<Party>();
    private int UUID = 0;
    private int score;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Player> inviteeList = new ArrayList<>();
    private JavaPlugin plugin;

    public static int counterCreated = 0;
    public Party(JavaPlugin plugin){
        this.plugin = plugin;
        this.UUID = counterCreated;
        counterCreated++;
        this.score = 0;
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

    public ArrayList<Player> getInviteeList(){
        return inviteeList;
    }
    
    public void Purchuse(){
        /*for (Player p : players){
            p.Purchuse(Cart);
        }*/
    }

    //run when the plugin begins
    static public void init(){
    }

    static public void addInvitee(duks.feudalismminecraftgame.Player player, Party party){
        party.inviteeList.add(player);
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

