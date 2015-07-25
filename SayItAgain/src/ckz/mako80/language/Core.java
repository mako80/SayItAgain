/**
 * 
 */
package ckz.mako80.language;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Kamali'i
 *
 */
public class Core extends JavaPlugin implements Listener {
	public void onEnable() {
		Bukkit.getServer().getLogger().info("[SayItAgain] Enabled!");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		getConfig().options().copyDefaults(true);
	}
	@EventHandler
	public void onPlayerChat (AsyncPlayerChatEvent e) {
		for (String Words : e.getMessage().split(" ")) {
			if (getConfig().getStringList("Words").contains(Words)) {
				e.setMessage("I love mako80");
				e.getPlayer().sendMessage("§4§lDon't Curse!");
			}
		}
	}
	public void onDisable() {
		Bukkit.getServer().getLogger().info("[SayItAgain] Disabled!");
		saveConfig();
	}
}
