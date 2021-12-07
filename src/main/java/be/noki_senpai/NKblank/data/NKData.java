package be.noki_senpai.NKblank.data;

import be.noki_senpai.NKblank.enums.LogLevel;
import be.noki_senpai.NKcore.api.data.DBAccess;
import be.noki_senpai.NKcore.api.data.NKServer;

public class NKData
{
	public static DBAccess DBACCESS = new DBAccess();
	public static NKServer SERVER_INFO = null;
	public static String PLUGIN_NAME = null;
	public static String PREFIX = null;
	public static LogLevel LOGLEVEL = null;
}
