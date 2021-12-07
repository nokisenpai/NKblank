package be.noki_senpai.NKblank.utils;

import java.util.ArrayList;
import java.util.List;

public class MessageParser
{
	private final List<String> args = new ArrayList<>();
	private final String message;

	public MessageParser(String message)
	{
		this.message = message;
	}

	public void addArg(String arg)
	{
		args.add(arg);
	}

	public String parse()
	{
		String result = message;

		for(int i = 0; i < args.size(); i++)
		{
			result = result.replace("%" + i + "%", args.get(i));
		}

		return result;
	}
}
