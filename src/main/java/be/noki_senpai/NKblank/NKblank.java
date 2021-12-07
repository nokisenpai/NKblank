package be.noki_senpai.NKblank;

import be.noki_senpai.NKblank.data.NKData;
import be.noki_senpai.NKblank.exceptions.SetupException;
import be.noki_senpai.NKblank.managers.ConfigManager;
import be.noki_senpai.NKblank.managers.DatabaseManager;
import be.noki_senpai.NKblank.managers.NKcoreAPIManager;
import be.noki_senpai.NKblank.managers.PlayerManager;
import be.noki_senpai.NKblank.registers.CommandRegister;
import be.noki_senpai.NKblank.registers.CompleterRegister;
import be.noki_senpai.NKblank.registers.ListenerRegister;
import be.noki_senpai.NKblank.utils.NKLogger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class NKblank extends JavaPlugin
{
	private static NKblank plugin = null;

	@Override
	public void onEnable()
	{
		plugin = this;
		NKData.PLUGIN_NAME = this.getName();

		this.saveDefaultConfig();

		// Init
		NKLogger.init(Bukkit.getConsoleSender());
		ConfigManager.init(getConfig());

		// Load
		try
		{
			NKcoreAPIManager.load(this);
			ConfigManager.load();
			DatabaseManager.load();
			PlayerManager.load();
		}
		catch(SetupException e)
		{
			NKLogger.error(e.getMessage());
			disablePlugin();

			return;
		}

		//Register
		ListenerRegister.registerAllListeners(this);
		CommandRegister.registerAllCommands(this);
		CompleterRegister.registerAllCompleters(this);

		displayNKSuccess();
	}

	@Override
	public void onDisable()
	{
		DatabaseManager.unload();
		PlayerManager.unload();
	}

	public void disablePlugin()
	{
		getServer().getPluginManager().disablePlugin(this);
	}

	public static NKblank getPlugin()
	{
		return plugin;
	}

	private void displayNKSuccess()
	{
		NKLogger.show("\n"
				+ ChatColor.WHITE + "\u00A0 \u00A0 \u00A0.--.\n"
				+ "\u00A0 \u00A0 \u00A0| \u00A0 '. \u00A0" + ChatColor.GREEN + NKData.PLUGIN_NAME + " by " + getDescription().getAuthors().get(0)
				+ " - successfully enabled !\n"
				+ ChatColor.WHITE + "'-..___.-'");
	}
}
