package be.noki_senpai.NKblank.enums;

import be.noki_senpai.NKblank.data.NKData;

public enum Permissions
{
	USER("user"),
	MODO("modo"),
	ADMIN("admin"),

	MYCOMMAND_CMD("mycommand"),
	MYCOMMANDWITHSUBCOMMAND_CMD("mycommandwithsubcommand"),
	MYCOMMANDWITHSUBCOMMAND_FIRST_CMD("mycommandwithsubcommand.first"),
	MYCOMMANDWITHSUBCOMMAND_SECOND_CMD("mycommandwithsubcommand.second");

	private final String value;

	Permissions(String value)
	{
		this.value = value;
	}

	public String toString()
	{
		return NKData.PLUGIN_NAME + "." + this.value;
	}
}
