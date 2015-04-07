package no.atc.osvein.bukkit.example;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        // Anything that needs to be done when starting up goes here 
        // ...
    	
    	// Register event handlers
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this, this);
        
        // Log message example
        getLogger().info("ExamplePlugin ready");
        
    }
    
    @Override
    public void onDisable()
    {

    	// Anything that needs to be done when shutting down goes here 
        // ...
    
    }
    
    // Event handler example
    @EventHandler
    public boolean onLogin( PlayerLoginEvent event ) {
        Player player = event.getPlayer();
        getLogger().info("Player '"+player.getName()+"' logged in");
    	return true; // Some event handlers must return a boolean
    }

    // Another event handler example
    @EventHandler
    public void onInteract( PlayerInteractEvent event ) {
        if (event.hasBlock()) {
            Player player = event.getPlayer();
            String pname = player.getName();
	    	Block block = event.getClickedBlock();
	    	World world = block.getWorld();
        }
        return; // Other event handlers should return nothing
    }
}

