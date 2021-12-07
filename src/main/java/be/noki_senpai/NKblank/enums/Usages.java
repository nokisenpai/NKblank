package be.noki_senpai.NKblank.enums;

/**
 *
 */
public enum Usages
{
	MYCOMMAND("/mycommand"),
	MYCOMMANDWITHSUBCOMMAND("/mycommandwithsubcommand <first|second>");

	private final String value;

	Usages(String value)
	{
		this.value = value;
	}

	public String toString()
	{
		return InternalMessages.PREFIX_USAGE + this.value;
	}
}
