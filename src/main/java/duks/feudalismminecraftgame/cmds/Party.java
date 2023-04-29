package duks.feudalismminecraftgame.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

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
            sender.sendMessage("need arguments");
            return true;
        }

        //leave party
        if(args[0].toLowerCase().equals("leave")){
            Player senderPlayer = (Player) sender;
            duks.feudalismminecraftgame.Party party = duks.feudalismminecraftgame.Player.findPlayerByUUID(senderPlayer.getUniqueId()).getParty();

            duks.feudalismminecraftgame.Party.removePlayerFromParty(duks.feudalismminecraftgame.Player.findPlayerByUUID(senderPlayer.getUniqueId()),plugin);
            sender.sendMessage("you've left the party");

            party.echo(sender.getName()+" has left the party");
        }

        //list party
        else if (args[0].toLowerCase().equals("list") || args[0].toLowerCase().equals("l")) {
            duks.feudalismminecraftgame.Player fPlayer = duks.feudalismminecraftgame.Player.findPlayerByUUID( ((Player) sender).getUniqueId() );
            duks.feudalismminecraftgame.Party party = fPlayer.getParty();

            sender.sendMessage(party.toString());
        }

        //checks if there are engouth arguments
        if(args.length<=1){
            sender.sendMessage("missing arguments");
            return true;
        }

        //invite
        else if(args[0].toLowerCase().equals("invite")){
            String inviteeName = args[1];
            UUID inviteeUUID = plugin.getServer().getPlayer(inviteeName).getUniqueId();
            Player pSender = plugin.getServer().getPlayer(sender.getName());
            duks.feudalismminecraftgame.Player fSender = duks.feudalismminecraftgame.Player.findPlayerByUUID(pSender.getUniqueId());
            duks.feudalismminecraftgame.Party party = fSender.getParty();
            duks.feudalismminecraftgame.Party.addInvitee(inviteeUUID, party);

            sender.sendMessage("you've invited "+inviteeName+" to the party");
        }

        //join party
        else if(args[0].toLowerCase().equals("join")){
            //gets player and sender
            String playerName = args[1];
            Player player = plugin.getServer().getPlayer(playerName);
            Player senderPlayer = (Player) sender;

            plugin.getServer().broadcastMessage(duks.feudalismminecraftgame.Player.findPlayerByUUID(player.getUniqueId())+"");
            duks.feudalismminecraftgame.Player fPlayer = duks.feudalismminecraftgame.Player.findPlayerByUUID(player.getUniqueId());
            duks.feudalismminecraftgame.Party party = fPlayer.getParty();

            if(!(party.getInviteeList().contains(senderPlayer.getUniqueId()))){
                sender.sendMessage("you are not invited to this party");
            }
            else{
                duks.feudalismminecraftgame.Party.addPlayerToParty(duks.feudalismminecraftgame.Player.findPlayerByUUID( ((Player) sender).getUniqueId() ), party, plugin);
                sender.sendMessage("you joined the party");
                party.echo(sender.getName()+" has joined the party");
            }
        }

        return true;
    }
}
