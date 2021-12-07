package be.noki_senpai.NKblank.commands.MyCommandWithSubcommands;

import be.noki_senpai.NKblank.enums.Messages;
import be.noki_senpai.NKblank.enums.Permissions;
import be.noki_senpai.NKblank.utils.MessageParser;
import org.bukkit.command.CommandSender;

public class Second
{
	public Second()
	{

	}

	public boolean second(CommandSender sender, String[] args)
	{
		if(!hasMyCommandWithSubcommandsSecondPermissions(sender))
		{
			sender.sendMessage(Messages.PERMISSION_MISSING.toString());

			return true;
		}

		MessageParser messageParser = new MessageParser(Messages.MYCOMMANDWITHSUBCOMMAND_MSG.toString());
		messageParser.addArg(args[0].toLowerCase());

		sender.sendMessage(messageParser.parse());

		return true;
	}

	private boolean hasMyCommandWithSubcommandsSecondPermissions(CommandSender sender)
	{
		return sender.hasPermission(Permissions.MYCOMMANDWITHSUBCOMMAND_SECOND_CMD.toString()) ||
				sender.hasPermission(Permissions.USER.toString()) ||
				sender.hasPermission(Permissions.ADMIN.toString());
	}
}
