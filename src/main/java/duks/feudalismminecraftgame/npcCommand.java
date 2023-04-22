package duks.feudalismminecraftgame;


//import net.minecraft.server.level.ServerPlayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class npcCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player){
            CraftPlayer craftPlayer = (CraftPlayer) sender;
            craftPlayer.getHandle();
            //ServerPlayer npc = new ServerPlayer();
        }

        return true;
    }
}
