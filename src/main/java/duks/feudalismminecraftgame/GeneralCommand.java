package duks.feudalismminecraftgame;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GeneralCommand implements CommandExecutor{
    JavaPlugin plugin;
    public GeneralCommand(JavaPlugin plugin){
        this.plugin=plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        plugin.getServer().broadcastMessage("npc moment");
        if(sender instanceof Player){
            System.out.println("aaa");
            plugin.getServer().broadcastMessage("npc moment");
        }

        return true;
    }
}
