//bruh moment
package duks.feudalismminecraftgame;

import duks.feudalismminecraftgame.mods.*;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class FeudalismMinecraftGame extends JavaPlugin implements Listener {
    private ArrayList<Team> teams = new ArrayList<Team>();
    private Mod mod;

    @Override
    public void onEnable() {
        System.out.println("ok");
        getServer().getPluginManager().registerEvents(this, this);
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
        //getServer().broadcastMessage(b+"");
        System.out.println(p.getClass());

        CraftPlayer craftPlayer = (CraftPlayer) p;

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        System.out.println("some1 has joined");
        e.setJoinMessage(ChatColor.YELLOW+"Ilay 3 joined the game");
        
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }
}
