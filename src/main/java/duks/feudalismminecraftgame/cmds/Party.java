package duks.feudalismminecraftgame.cmds;

import java.util.UUID;

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
        //check if sender is a player
        if(!(sender instanceof Player)){
            return true;
        }

        //checks if there are engouth arguments
        else if(args.length<=0){
            sender.sendMessage("need arguments (only you can see this msg)");
            return true;
        }

        //leave party
        if(args[0].toLowerCase().equals("leave")){
            duks.feudalismminecraftgame.Party.removePlayerFromParty(duks.feudalismminecraftgame.Player.findPlayerByUUID( ((Player) sender).getUniqueId() ),plugin);
            sender.sendMessage("you left the party (only you can see this msg)");
        }

        //list party
        else if (args[0].toLowerCase().equals("list") || args[0].toLowerCase().equals("l")) {
            duks.feudalismminecraftgame.Player fPlayer = duks.feudalismminecraftgame.Player.findPlayerByUUID( ((Player) sender).getUniqueId() );
            duks.feudalismminecraftgame.Party party = fPlayer.getParty();
            plugin.getServer().broadcastMessage(party.getMembers().toString());
            String s = fPlayer.getParty().getMembers().toString();
        }

        //checks if there are engouth arguments
        if(args.length<=1){
            sender.sendMessage("missing arguments (only you can see this msg)");
            return true;
        }

        //invite
        else if(args[0].toLowerCase().equals("invite")){
            String inviteeName = args[1];
            UUID inviteeUUID = plugin.getServer().getPlayer(inviteeName).getUniqueId();
            Player pSender = plugin.getServer().getPlayer(sender.getName());
            duks.feudalismminecraftgame.Player fSender = duks.feudalismminecraftgame.Player.findPlayerByUUID(pSender.getUniqueId());
            duks.feudalismminecraftgame.Party party = fSender.getParty();
            duks.feudalismminecraftgame.Party.addInvitee(inviteeUUID, party,plugin);

            sender.sendMessage("you've invated "+inviteeName+" (only you can see this msg)");
            
            sender.sendMessage(party.getUUID()+"");
            sender.sendMessage(party.getInviteeList().toString());
        }
        
        //join party
        else if(args[0].toLowerCase().equals("join")){
            String playerName = args[1];
            Player player = plugin.getServer().getPlayer(playerName);
            plugin.getServer().broadcastMessage(duks.feudalismminecraftgame.Player.findPlayerByUUID(player.getUniqueId())+"");
            duks.feudalismminecraftgame.Player fPlayer = duks.feudalismminecraftgame.Player.findPlayerByUUID(player.getUniqueId());
            duks.feudalismminecraftgame.Party party = fPlayer.getParty();
            if(!(party.getInviteeList().contains(player.getUniqueId()))){
                sender.sendMessage("you are not invited to this party (only you can see this msg)");
                return true;
            }
            duks.feudalismminecraftgame.Party.addPlayerToParty(duks.feudalismminecraftgame.Player.findPlayerByUUID( ((Player) sender).getUniqueId() ), party, plugin);
            sender.sendMessage("added you to the party (only you can see this msg)");
            sender.sendMessage(party.getUUID()+"");
        }

        return true;
    }
}
