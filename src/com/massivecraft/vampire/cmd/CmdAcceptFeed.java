package com.massivecraft.vampire.cmd;

import com.massivecraft.vampire.zcore.CommandVisibility;

public class CmdAcceptFeed extends VCommand
{
	
	public CmdAcceptFeed()
	{
		aliases.add("acceptfeed");
		
		helpShort = "accept a feed request from a vampire";
		
		this.visibility = CommandVisibility.INVISIBLE;
		
		senderMustBePlayer = true;
		senderMustBeVampire = false;
	}
	
	@Override
	public void perform()
	{
		vme.acceptFeed();
	}
}
