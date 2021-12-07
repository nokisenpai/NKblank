package be.noki_senpai.NKblank.managers;

import be.noki_senpai.NKblank.data.NKData;
import be.noki_senpai.NKblank.enums.InternalMessages;
import be.noki_senpai.NKblank.enums.LogLevel;
import be.noki_senpai.NKblank.utils.NKLogger;
import be.noki_senpai.NKcore.api.data.DBAccess;
import org.bukkit.configuration.file.FileConfiguration;

public final class ConfigManager
{
	private ConfigManager() {}

	private static FileConfiguration config = null;

	public static void init(FileConfiguration config)
	{
		ConfigManager.config = config;
	}

	public static void load()
	{
		boolean useNKcoreAccess = config.getBoolean("use-nkcore-access", true);
		if(useNKcoreAccess)
		{
			NKData.DBACCESS = NKcoreAPIManager.nKcoreAPI.getDBAccess();
		}
		else
		{
			DBAccess dbAccess = new DBAccess();
			dbAccess.setHost(config.getString("host"));
			dbAccess.setPort(config.getInt("port"));
			dbAccess.setDbName(config.getString("dbName"));
			dbAccess.setUser(config.getString("user"));
			dbAccess.setPassword(config.getString("password"));
		}

		NKData.PREFIX = config.getString("table-prefix", NKData.PLUGIN_NAME + "_");

		NKData.SERVER_INFO = NKcoreAPIManager.nKcoreAPI.getNKServer();

		try
		{
			NKData.LOGLEVEL = LogLevel.valueOf(config.getString("log-level", "LOG"));
		}
		catch(IllegalArgumentException e)
		{
			NKLogger.error(InternalMessages.CONFIG_KEY_LOGLEVEL_BAD_VALUE.toString());
			NKData.LOGLEVEL = LogLevel.LOG;
		}

		NKLogger.setLogLevel(NKData.LOGLEVEL);

		//throw new SetupException("My exception message");
	}
}
