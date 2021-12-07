package be.noki_senpai.NKblank.registers;

import be.noki_senpai.NKblank.commands.MyCommandCmd;
import be.noki_senpai.NKblank.commands.MyCommandWithSubcommandsCmd;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class CommandRegister
{
	private static final Map<String, CommandExecutor> commands = setCommands();

	public static void registerAllCommands(JavaPlugin plugin)
	{
		commands.forEach((commandName, commandExecutor) ->
		{
			PluginCommand command = plugin.getCommand(commandName);
			if(command != null)
			{
				command.setExecutor(commandExecutor);
			}
		});
	}

	private static Map<String, CommandExecutor> setCommands()
	{
		Map<String, CommandExecutor> commands = new HashMap<>();
		commands.put("mycommand", new MyCommandCmd());
		commands.put("mycommandwithsubcommands", new MyCommandWithSubcommandsCmd());

		return commands;
	}
}
