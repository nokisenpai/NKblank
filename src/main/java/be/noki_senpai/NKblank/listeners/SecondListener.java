package be.noki_senpai.NKblank.listeners;

import be.noki_senpai.NKblank.enums.Messages;
import be.noki_senpai.NKblank.utils.MessageParser;
import be.noki_senpai.NKblank.utils.NKLogger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class SecondListener implements Listener
{
	public SecondListener()
	{

	}

	@EventHandler
	public void onPlayerQuitEvent(final PlayerQuitEvent event)
	{
		event.setQuitMessage(null);

		MessageParser messageParser = new MessageParser(Messages.PLAYER_QUIT_MSG.toString());
		messageParser.addArg(event.getPlayer().getDisplayName());

		NKLogger.log(messageParser.parse());
	}
}