package be.noki_senpai.NKblank.enums;

import org.bukkit.ChatColor;

public enum Messages
{
	PERMISSION_MISSING(ChatColor.RED + "Vous n'avez pas la permission."),
	MYCOMMAND_SUCCESS_PLAYER(ChatColor.GREEN + "Vous avez utilisé la commande " + ChatColor.AQUA + "mycommand" + ChatColor.GREEN + " en tant que joueur."),
	MYCOMMAND_SUCCESS_CONSOLE(ChatColor.GREEN + "Vous avez utilisé la commande " + ChatColor.AQUA + "mycommand" + ChatColor.GREEN + " dans la console."),
	MYCOMMANDWITHSUBCOMMAND_DENY_CONSOLE(ChatColor.RED + "Vous ne pouvez pas utiliser cette commande dans la console."),
	MYCOMMANDWITHSUBCOMMAND_MSG(ChatColor.GREEN + "Vous avez utilisé l'argument " + ChatColor.DARK_AQUA + "%0%" + ChatColor.GREEN + "."),
	PLAYER_JOIN_MSG(ChatColor.GREEN + "Bienvenue à toi " + ChatColor.DARK_AQUA + "%0%" + ChatColor.GREEN + " !"),
	PLAYER_QUIT_MSG(ChatColor.GREEN + "Le joueur " + ChatColor.DARK_AQUA + "%0%" + ChatColor.GREEN + " s'est déconnecté.");

	private final String value;

	Messages(String value)
	{
		this.value = value;
	}

	public String toString()
	{
		return this.value;
	}
}
