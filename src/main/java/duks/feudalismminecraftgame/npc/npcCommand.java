package duks.feudalismminecraftgame.npc;
import duks.feudalismminecraftgame.FeudalismMinecraftGame;



//import net.minecraft.server.level.ServerPlayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class npcCommand implements CommandExecutor {
    JavaPlugin plugin;
    public npcCommand(JavaPlugin plugin){
        this.plugin=plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player){
            System.out.println("aaa");
            plugin.getServer().broadcastMessage("npc moment");
        }

        return true;
    }
}
