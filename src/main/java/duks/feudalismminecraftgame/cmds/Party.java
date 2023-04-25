package duks.feudalismminecraftgame.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Party implements CommandExecutor {
    JavaPlugin plugin;

    public Party(JavaPlugin plugin){
        this.plugin=plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(!(sender instanceof Player)){
            return true;
        }

        if(args.length<=0){
            sender.sendMessage("need arguments (only you can see this msg)");
            return true;
        }
        if(args[0].toLowerCase().equals("leave")){
            duks.feudalismminecraftgame.Party.removePlayerFromParty(duks.feudalismminecraftgame.Player.findPlayerByUUID( ((Player) sender).getUniqueId() ),plugin);
            sender.sendMessage("you left the party (only you can see this msg)");
        }
        else if(args[0].toLowerCase().equals("join")){
            if(args.length<=1){
                sender.sendMessage("missing arguments (only you can see this msg)");
                return true;
            }
            String playerName = args[1];
            Player player = plugin.getServer().getPlayer(playerName);
            plugin.getServer().broadcastMessage(duks.feudalismminecraftgame.Player.findPlayerByUUID(player.getUniqueId())+"");
            duks.feudalismminecraftgame.Player fPlayer = duks.feudalismminecraftgame.Player.findPlayerByUUID(player.getUniqueId());
            duks.feudalismminecraftgame.Party party = fPlayer.getParty();
            duks.feudalismminecraftgame.Party.addPlayerToParty(duks.feudalismminecraftgame.Player.findPlayerByUUID( ((Player) sender).getUniqueId() ), party, plugin);
            sender.sendMessage("added you to the party (only you can see this msg)");
            sender.sendMessage(party.getUUID()+"");
        }
        else if (args[0].toLowerCase().equals("list") || args[0].toLowerCase().equals("l")) {
            duks.feudalismminecraftgame.Player fPlayer = duks.feudalismminecraftgame.Player.findPlayerByUUID( ((Player) sender).getUniqueId() );
            duks.feudalismminecraftgame.Party party = fPlayer.getParty();
            plugin.getServer().broadcastMessage(party.getMembers().toString());
            String s = fPlayer.getParty().getMembers().toString();
        }

        return true;
    }
}
