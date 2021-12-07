package be.noki_senpai.NKblank.managers;

import be.noki_senpai.NKcore.api.data.NKPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.TreeMap;

public final class PlayerManager
{
	private static final Map<String, NKPlayer> players = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

	private PlayerManager() {}

	public static void load()
	{
		Bukkit.getOnlinePlayers().forEach(player -> players.put(player.getDisplayName(), new NKPlayer(player.getUniqueId(), player.getName())));
	}

	public static void unload()
	{
		players.clear();
	}

	public static NKPlayer getPlayer(String playerName)
	{
		if(players.containsKey(playerName))
		{
			return players.get(playerName);
		}

		return NKcoreAPIManager.nKcoreAPI.getNKPlayer(playerName);
	}

	public static void addPlayer(Player player)
	{
		players.put(player.getName(), new NKPlayer(player.getUniqueId(), player.getName()));
	}

	public static void delPlayer(String playerName)
	{
		players.remove(playerName);
	}
}
