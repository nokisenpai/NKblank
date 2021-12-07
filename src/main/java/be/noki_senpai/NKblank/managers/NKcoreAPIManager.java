package be.noki_senpai.NKblank.managers;

import be.noki_senpai.NKblank.data.NKcoreEventAPIimpl;
import be.noki_senpai.NKblank.enums.InternalMessages;
import be.noki_senpai.NKblank.exceptions.SetupException;
import be.noki_senpai.NKcore.api.NKcoreAPI;
import be.noki_senpai.NKcore.api.NKcoreEventAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public final class NKcoreAPIManager
{
	private NKcoreAPIManager() {}

	public static NKcoreAPI nKcoreAPI = null;

	public static void load(JavaPlugin plugin) throws SetupException
	{
		if(Bukkit.getServer().getPluginManager().getPlugin("NKcore") == null)
		{
			throw new SetupException(InternalMessages.NKCORE_MISSING.toString());
		}

		RegisteredServiceProvider<NKcoreAPI> rsp = Bukkit.getServer().getServicesManager().getRegistration(NKcoreAPI.class);

		if(rsp == null)
		{
			throw new SetupException(InternalMessages.NKCORE_CANT_GET_API.toString());
		}

		nKcoreAPI = rsp.getProvider();

		Bukkit.getServicesManager().register(NKcoreEventAPI.class, new NKcoreEventAPIimpl(), plugin, ServicePriority.Normal);
	}
}
