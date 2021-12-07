package be.noki_senpai.NKblank.completers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MyCommandCompleter implements TabCompleter
{
	public MyCommandCompleter()
	{

	}

	@Override
	public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args)
	{
		return null;
	}
}