package duks.feudalismminecraftgame.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class JoinCmd implements CommandExecutor {
    JavaPlugin plugin;
    public JoinCmd(JavaPlugin plugin){
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