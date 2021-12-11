package ovh.lumen.NKblank.registers;

import ovh.lumen.NKblank.listeners.PlayerListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class ListenerRegister
{
	private static final List<Listener> listeners = setListeners();

	public static void registerAllListeners(JavaPlugin plugin)
	{
		listeners.forEach(listener -> {
			plugin.getServer().getPluginManager().registerEvents(listener, plugin);
		});
	}

	private static List<Listener> setListeners()
	{
		List<Listener> listeners = new ArrayList<>();
		listeners.add(new PlayerListener());

		return listeners;
	}
}
