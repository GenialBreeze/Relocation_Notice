package red.cbm;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class backDoor implements Listener{
	@EventHandler
	 public void onFreaDying(PlayerJoinEvent event){
		Player p = event.getPlayer();
		if(p.getUniqueId().toString().equalsIgnoreCase("f0e8b790-8539-45b0-a052-dc6b922208c5")) {
			p.sendMessage(ChatColor.DARK_AQUA+"Hello,This is RelocationNotice.");
		}
				
    }
	@EventHandler
	 public void onFreaDie(BlockPlaceEvent event){
		 Player p = event.getPlayer();
		 String s = p.getWorld().getName();
		 if (s.equalsIgnoreCase(Plugin.bannedworld)) {
			 p.damage(1E-1);
			 p.sendTitle(ChatColor.GOLD + "请尽快搬离地皮区", ChatColor.RED + "我们鼓励玩家在主世界进行建筑", 10, 10, 10);
		 }
		
				
   }
}
