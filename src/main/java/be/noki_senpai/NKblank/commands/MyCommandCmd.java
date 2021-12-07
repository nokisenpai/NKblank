package be.noki_senpai.NKblank.commands;

import be.noki_senpai.NKblank.enums.Messages;
import be.noki_senpai.NKblank.enums.Permissions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MyCommandCmd implements CommandExecutor
{
	public MyCommandCmd()
	{

	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args)
	{
		if(sender instanceof Player)
		{
			if(!hasMyCommandPermissions(sender))
			{
				sender.sendMessage(Messages.PERMISSION_MISSING.toString());

				return true;
			}

			sender.sendMessage(Messages.MYCOMMAND_SUCCESS_PLAYER.toString());
			return true;
		}

		if(sender instanceof ConsoleCommandSender)
		{
			sender.sendMessage(Messages.MYCOMMAND_SUCCESS_CONSOLE.toString());
			return true;
		}

		return true;
	}

	private boolean hasMyCommandPermissions(CommandSender sender)
	{
		return sender.hasPermission(Permissions.MYCOMMAND_CMD.toString()) ||
				sender.hasPermission(Permissions.USER.toString()) ||
				sender.hasPermission(Permissions.ADMIN.toString());
	}
}
