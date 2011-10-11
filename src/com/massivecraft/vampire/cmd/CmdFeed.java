package com.massivecraft.vampire.cmd;

import org.bukkit.entity.Player;

import com.massivecraft.vampire.*;

public class CmdFeed extends VCommand
{
	
	public CmdFeed()
	{
		aliases.add("feed");
		
		requiredArgs.add("playername");
		
		helpShort = "feed from others that are willing";
		
		permission = Permission.COMMAND_FEED.node;
		senderMustBePlayer = true;
		senderMustBeVampire = true;
	}
	
	@Override
	public void perform()
	{
		Player you = this.argAsBestPlayerMatch(0);
		if (you == null) return;
		VPlayer vyou = VPlayers.i.get(you);
		//vme.offerInfectionTo(vyou);
		vme.offerFeedTo(vyou);
	}
}
