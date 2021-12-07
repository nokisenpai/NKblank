package be.noki_senpai.NKblank.registers;

import be.noki_senpai.NKblank.listeners.FirstListener;
import be.noki_senpai.NKblank.listeners.SecondListener;
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
		listeners.add(new FirstListener());
		listeners.add(new SecondListener());

		return listeners;
	}
}
