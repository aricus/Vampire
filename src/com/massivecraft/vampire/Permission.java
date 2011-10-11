package com.massivecraft.vampire;

import org.bukkit.command.CommandSender;

public enum Permission
{
	IS("vampire.is"),
	COMMAND_INTEND("vampire.command.intend"),
	COMMAND_INFECT("vampire.command.infect"),
	COMMAND_LIST("vampire.command.list"),
	COMMAND_TURN("vampire.command.turn"),
	COMMAND_CURE("vampire.command.cure"),
	COMMAND_SETINFECTION("vampire.command.setinfection"),
	COMMAND_SETFOOD("vampire.command.setfood"),
	COMMAND_VERSION("vampire.command.version"),
	COMMAND_FEED("vampire.command.feed"),
	;
	
	public final String node;
	
	Permission(final String permissionNode)
	{
		this.node = permissionNode;
    }
	
	public boolean has(CommandSender sender, boolean informSenderIfNot)
	{
		return P.p.perm.has(sender, this.node, informSenderIfNot);
	}
	
	public boolean has(CommandSender sender)
	{
		return has(sender, false);
	}
}
