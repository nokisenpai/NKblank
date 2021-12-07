package be.noki_senpai.NKblank.registers;

import be.noki_senpai.NKblank.completers.MyCommandCompleter;
import be.noki_senpai.NKblank.completers.MyCommandWithSubcommandsCompleter;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class CompleterRegister
{
	private static final Map<String, TabCompleter> completers = setCompleters();

	public static void registerAllCompleters(JavaPlugin plugin)
	{
		completers.forEach((commandName, tabCompleter) ->
		{
			PluginCommand command = plugin.getCommand(commandName);
			if(command != null)
			{
				command.setTabCompleter(tabCompleter);
			}
		});
	}

	private static Map<String, TabCompleter> setCompleters()
	{
		Map<String, TabCompleter> commands = new HashMap<>();
		commands.put("mycommand", new MyCommandCompleter());
		commands.put("mycommandwithsubcommands", new MyCommandWithSubcommandsCompleter());

		return commands;
	}
}
