package duks.feudalismminecraftgame;

import duks.feudalismminecraftgame.mods.*;

import java.util.UUID;
import java.util.stream.Stream;

import duks.feudalismminecraftgame.npc.npcCommand;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class FeudalismMinecraftGame extends JavaPlugin implements Listener {
    private Mod mod;

    @Override
    public void onEnable() {

        System.out.println("ok");
        getServer().getPluginManager().registerEvents(this, this);
        this.getCommand("npc").setExecutor(new npcCommand(this));
        this.getCommand("party").setExecutor(new duks.feudalismminecraftgame.cmds.Party(this));
        this.getCommand("p").setExecutor(new duks.feudalismminecraftgame.cmds.Party(this));

        //Stream<? extends Player> players = getServer().getOnlinePlayers().stream();
        //players.map(x->(Player)x).forEach(y->artificialPlayerJoin(y));

        Party.init();
    }

    @Override
    public void onDisable(){

    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Block b = e.getBlock();
        Player p = e.getPlayer();
        Location l = b.getLocation();
        double x = l.getX();
        double y = l.getY();
        double z = l.getZ();
        UUID uuid = p.getUniqueId();
        //getServer().broadcastMessage(b+"");
        System.out.println(p.getClass());

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        System.out.println("some1 has joined");
        e.setJoinMessage(ChatColor.YELLOW+"some1 joined the game");
        Player player = e.getPlayer();
        artificialPlayerJoin(player);
    }
    
    private void artificialPlayerJoin(Player player){
        //party problem
        UUID uuid = player.getUniqueId();
        duks.feudalismminecraftgame.Player fPlayer = duks.feudalismminecraftgame.Player.findPlayerByUUID(uuid);
        if(fPlayer==null){//first time in server
            fPlayer = new duks.feudalismminecraftgame.Player(uuid, this);//register (without party)
            Party.addPlayerToParty(fPlayer, null , this);//add to default party

            getServer().broadcastMessage(duks.feudalismminecraftgame.Player.uuidPlayerMap.toString());

        }
        //should have a party otherwise but just in case:
        else if(fPlayer.getParty() == null){
            Party.addPlayerToParty(fPlayer, null , this);
        }
        getServer().broadcastMessage(fPlayer.getParty().getUUID()+"");
    }
}
