//ilay3
package duks.feudalismminecraftgame;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.world.AsyncStructureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public final class FeudalismMinecraftGame extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("ok");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {

    }
    @EventHandler
    public void summonVillagerInBunker(AsyncStructureSpawnEvent event){
        getServer().broadcastMessage(" bro.");
        int x = event.getChunkX();
        int z = event.getChunkZ();
        getServer().broadcastMessage(" brah.");
        System.out.println(event.getHandlers().toString());
        Location l = new Location(Bukkit.getWorld("world"), (double)x*16,64.0,(double)z*16);
        getServer().broadcastMessage(" bruh.");
        getServer().broadcastMessage((int)x*16+" "+(int)z*16+" bro.");
        spawnNPC(l, "My Villager", Villager.Profession.FARMER);
        getServer().broadcastMessage(" brauh.");
        getServer().broadcastMessage((int)x*16+" "+(int)z*16+" bro.");

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
        System.out.println(p.getClass()+"!!!!");

        //CraftPlayer craftPlayer = (CraftPlayer) p;
        getServer().broadcastMessage(p+"is an idiot");
        Location location = new Location(Bukkit.getWorld("world"), 0, 64, 0);
        //spawnNPC(l, "My Villager", Villager.Profession.FARMER);
        //spawnNPC(l, "My Villager");

    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        System.out.println("some1 has joined");
        e.setJoinMessage(ChatColor.YELLOW+"Ilay 3 joined the game");

    }
    private void spawnNPC(Location location, String displayName, Villager.Profession profession) {
        // Spawn a Villager at the specified location
        Villager villager = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER);

        // Set the Villager properties
        villager.setCustomName(displayName);
        villager.setCustomNameVisible(true);
        villager.setProfession(profession);
        villager.setAI(false);

        // Set the Villager's trades (optional)
        // villager.setRecipes(yourRecipeList);
    }
    private void spawnNPC(Location location, String name) {
        //implement me!!!
    }
}
