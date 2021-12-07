package be.noki_senpai.NKblank.enums;

import org.bukkit.ChatColor;

public enum InternalMessages
{
	PREFIX_USAGE(ChatColor.BLUE + "Usage : "),
	CONFIG_KEY_LOGLEVEL_BAD_VALUE("Key 'log-level' has bad value in config.yml. Default value 'LOG' used."),
	NKCORE_MISSING("Can't find NKcore plugin."),
	NKCORE_CANT_GET_API("Can't get NKcore API."),
	DATABASE_CANT_CONNECT("Error while attempting database connection."),
	DATABASE_CANT_CHECK_TABLES("Error while testing tables existance."),
	DATABASE_CANT_CREATE_TABLES("Error while creating database structure."),
	DATABASE_CREATE_TABLES_SUCCESS(ChatColor.GREEN + "Database tables created.");

	private final String value;

	InternalMessages(String value)
	{
		this.value = value;
	}

	public String toString()
	{
		return this.value;
	}
}
