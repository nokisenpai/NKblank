package be.noki_senpai.NKblank.listeners;

import be.noki_senpai.NKblank.enums.Messages;
import be.noki_senpai.NKblank.utils.MessageParser;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstListener implements Listener
{
	public FirstListener()
	{

	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void PlayerJoinEvent(final PlayerJoinEvent event)
	{
		event.setJoinMessage(null);

		MessageParser messageParser = new MessageParser(Messages.PLAYER_JOIN_MSG.toString());
		messageParser.addArg(event.getPlayer().getDisplayName());

		event.getPlayer().sendMessage(messageParser.parse());
	}
}
