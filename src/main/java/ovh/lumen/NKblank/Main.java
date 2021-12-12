package ovh.lumen.NKblank;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import ovh.lumen.NKblank.data.NKData;
import ovh.lumen.NKblank.enums.InternalMessages;
import ovh.lumen.NKblank.exceptions.SetupException;
import ovh.lumen.NKblank.interfaces.NKplugin;
import ovh.lumen.NKblank.managers.ConfigManager;
import ovh.lumen.NKblank.managers.DatabaseManager;
import ovh.lumen.NKblank.managers.NKcoreAPIManager;
import ovh.lumen.NKblank.registers.CommandRegister;
import ovh.lumen.NKblank.registers.CompleterRegister;
import ovh.lumen.NKblank.registers.ListenerRegister;
import ovh.lumen.NKblank.utils.NKLogger;

public class Main extends JavaPlugin implements NKplugin
{
	@Override
	public void onEnable()
	{
		setup();
	}

	@Override
	public void onDisable()
	{
		clean();
	}

	@Override
	public void setup()
	{
		NKData.PLUGIN = this;
		NKData.PLUGIN_NAME = this.getName();
		NKData.PLUGIN_VERSION = this.getDescription().getVersion();
		NKData.PLUGIN_AUTHOR = this.getDescription().getAuthors().get(0);

		this.saveDefaultConfig();

		// Init
		NKLogger.init(Bukkit.getConsoleSender());
		ConfigManager.init(this.getConfig());

		// Load
		try
		{
			NKcoreAPIManager.load(this);
			ConfigManager.load();
			DatabaseManager.load();
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
	public void clean()
	{
		DatabaseManager.unload();
	}

	@Override
	public void reload()
	{
		NKLogger.send(InternalMessages.RELOAD_ANNOUNCE.toString());
		clean();
		setup();
	}

	public void disablePlugin()
	{
		getServer().getPluginManager().disablePlugin(this);
	}

	private void displayNKSuccess()
	{
		NKLogger.show("\n"
				+ ChatColor.WHITE + "\u00A0 \u00A0 \u00A0.--.\n"
				+ "\u00A0 \u00A0 \u00A0| \u00A0 '. \u00A0" + ChatColor.GREEN + NKData.PLUGIN_NAME + " v" + NKData.PLUGIN_VERSION + " by " + NKData.PLUGIN_AUTHOR
				+ " - successfully enabled !\n"
				+ ChatColor.WHITE + "'-..___.-'");
	}
}
