package be.noki_senpai.NKblank.commands;

import be.noki_senpai.NKblank.commands.MyCommandWithSubcommands.First;
import be.noki_senpai.NKblank.commands.MyCommandWithSubcommands.Second;
import be.noki_senpai.NKblank.enums.Messages;
import be.noki_senpai.NKblank.enums.Permissions;
import be.noki_senpai.NKblank.enums.Usages;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MyCommandWithSubcommandsCmd implements CommandExecutor
{
	public MyCommandWithSubcommandsCmd()
	{

	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, String[] args)
	{
		if(sender instanceof Player)
		{
			if(!hasMyCommandWithSubcommandsPermissions(sender))
			{
				sender.sendMessage(Messages.PERMISSION_MISSING.toString());

				return true;
			}


			if(args.length > 0)
			{
				args[0] = args[0].toLowerCase();
				switch(args[0])
				{
					case "first":
						return new First().first(sender, args);
					case "second":
						return new Second().second(sender, args);
					default:
						sender.sendMessage(Usages.MYCOMMANDWITHSUBCOMMAND.toString());
				}

				return true;
			}

			sender.sendMessage(Usages.MYCOMMANDWITHSUBCOMMAND.toString());

			return true;
		}

		if(sender instanceof ConsoleCommandSender)
		{
			sender.sendMessage(Messages.MYCOMMANDWITHSUBCOMMAND_DENY_CONSOLE.toString());
			return true;
		}

		return true;
	}

	private boolean hasMyCommandWithSubcommandsPermissions(CommandSender sender)
	{
		return sender.hasPermission(Permissions.MYCOMMANDWITHSUBCOMMAND_CMD.toString()) ||
				sender.hasPermission(Permissions.USER.toString()) ||
				sender.hasPermission(Permissions.ADMIN.toString());
	}
}
