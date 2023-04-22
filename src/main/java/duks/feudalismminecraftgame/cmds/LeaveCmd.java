package duks.feudalismminecraftgame.cmds;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LeaveCmd implements CommandExecutor {
    private JavaPlugin plugin;

    public LeaveCmd(JavaPlugin plugin){
        this.plugin=plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            
        }

        return true;
    }
}
