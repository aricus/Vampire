package com.massivecraft.vampire.cmd;

import com.massivecraft.vampire.config.Conf;

public class CmdBase extends VCommand
{
	public CmdAccept cmdAccept = new CmdAccept();
	public CmdAcceptFeed cmdAcceptFeed = new CmdAcceptFeed();
	
	public CmdBase()
	{
		super();
		this.aliases.addAll(Conf.baseCommandAliases);
		
		this.subCommands.add(p.cmdHelp);
		this.subCommands.add(new CmdIntend());
		this.subCommands.add(new CmdInfect());
		this.subCommands.add(new CmdFeed());
		this.subCommands.add(cmdAccept);
		this.subCommands.add(cmdAcceptFeed);
		this.subCommands.add(new CmdList());
		this.subCommands.add(new CmdSetfood());
		this.subCommands.add(new CmdSetinfection());
		this.subCommands.add(new CmdTurn());
		this.subCommands.add(new CmdCure());
		this.subCommands.add(new CmdVersion());
		
		this.helpShort = "The vampire base command";
		this.helpLong.add(p.txt.tags("<i>This command contains all vampire stuff."));
		
		this.allowNoSlashAccess = Conf.allowNoSlashCommand;
	}
	
	@Override
	public void perform()
	{
		this.commandChain.add(this);
		p.cmdHelp.execute(this.sender, this.args, this.commandChain);
	}

}
