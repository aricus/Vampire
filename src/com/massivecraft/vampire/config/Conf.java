package com.massivecraft.vampire.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.CreatureType;

import com.massivecraft.vampire.AltarEvil;
import com.massivecraft.vampire.AltarGood;
import com.massivecraft.vampire.P;


public class Conf
{
	public final static transient int taskInterval = 40; // Defines often the task runs.
	public final static transient double cmdInfectMaxDistance = 2d;
	public final static transient long cmdInfectMillisRecentTolerance = 10000;
	
	public static List<String> baseCommandAliases = new ArrayList<String>();
	public static boolean allowNoSlashCommand = true;
	
	public static Boolean nameColorize = false;
	public static ChatColor nameColor = ChatColor.RED;
	public static Set<Material> dropSelfOverrideMaterials = new HashSet<Material>();
	
	// TODO REMOVE!! Abstract...
	// Time is "hours passed since the beginning of the day" * 1000
	public final static transient int combustFromTime = 0;
	public final static transient int combustToTime = 12400;
	// After how many minecraft game ticks of no sunlight should the fire stop? 0 means right away.
	public static int combustFireExtinguishTicks = 10; 
	
	public static Double jumpDeltaSpeed = 3d;
	public static Integer jumpFoodCost = 2;
	public static Set<Material> jumpMaterials = new HashSet<Material>();
	
	public static double infectionProgressPerTick = 100D / (20*60*60D) ; // It will take you 1h to turn
	public static double infectionBreadHealAmount = 20D;
	
	public static Double infectionRiskAtCloseCombatWithoutIntent = 0.003;
	public static Double infectionRiskAtCloseCombatWithIntent = 0.05;
	
	
	
	// TODO: Rework to have different values for the intent modes!
	public static double damageDealtFactorWithoutIntent = 1.5;
	public static double damageDealtFactorWithIntent = 0.65;
	public static double damageReceivedFactorWithoutIntent = 0.65;
	public static double damageReceivedFactorWithIntent = 1.0;
	
	public static int damageReceivedWood = 11;
	public static Set<Material> woodMaterials = new HashSet<Material>();
	
	public static AltarEvil altarEvil = new AltarEvil();
	public static AltarGood altarGood = new AltarGood();
	public static Map<Material, Boolean> canEat = new HashMap<Material, Boolean>();
	
	
	
	
	public static double foodPerDamageFromPlayer = 0.4d;
	public static Map<CreatureType, Double> foodPerDamageFromCreature = new HashMap<CreatureType, Double>();
	
	public static long truceBreakTicks = 60 * 20; // One minute
	public static Set<CreatureType> creatureTypeTruceMonsters = new HashSet<CreatureType>();
	
	public static Map<Material,Double> materialOpacity = new HashMap<Material,Double>(); //We assume opacity 1 for all materials not in this map
	
	public static Map<String,Boolean> giveThesePermissionsToVampires  = new LinkedHashMap<String,Boolean>();
	public static Map<String,Boolean> giveThesePermissionsToNonVampires  = new LinkedHashMap<String,Boolean>();
	
	static
	{
		baseCommandAliases.add("v");
		
		dropSelfOverrideMaterials.add(Material.WEB);
		dropSelfOverrideMaterials.add(Material.GLOWSTONE);
		dropSelfOverrideMaterials.add(Material.BOOKSHELF);
		dropSelfOverrideMaterials.add(Material.DEAD_BUSH);
		
		jumpMaterials.add(Material.ENDER_PEARL);
		
		// http://www.minecraftwiki.net/wiki/Food
		canEat.put(Material.RAW_BEEF, true);
		canEat.put(Material.RAW_CHICKEN, true);
		canEat.put(Material.PORK, true);
		canEat.put(Material.COOKED_BEEF, false);
		canEat.put(Material.BREAD, false);
		canEat.put(Material.CAKE_BLOCK, false);
		canEat.put(Material.COOKIE, false);
		canEat.put(Material.COOKED_CHICKEN, false);
		canEat.put(Material.RAW_FISH, false);
		canEat.put(Material.COOKED_FISH, false);
		canEat.put(Material.GRILLED_PORK, false);
		canEat.put(Material.APPLE, false);
		canEat.put(Material.GOLDEN_APPLE, false);
		canEat.put(Material.MELON, false);
		canEat.put(Material.MUSHROOM_SOUP, false);
		canEat.put(Material.ROTTEN_FLESH, false);
		
		// TODO Maybe cake could cure vampirism...
		// "You forget about blood this is way better :)"
		woodMaterials.add(Material.WOOD_AXE);
		woodMaterials.add(Material.WOOD_HOE);
		woodMaterials.add(Material.WOOD_PICKAXE);
		woodMaterials.add(Material.WOOD_SPADE);
		woodMaterials.add(Material.WOOD_SWORD);
		woodMaterials.add(Material.STICK);
		woodMaterials.add(Material.TORCH);
		woodMaterials.add(Material.REDSTONE_TORCH_OFF);
		woodMaterials.add(Material.REDSTONE_TORCH_ON);
		woodMaterials.add(Material.SIGN);
		woodMaterials.add(Material.SIGN_POST);
		woodMaterials.add(Material.FENCE);
		woodMaterials.add(Material.FENCE_GATE);
		
		materialOpacity.put(Material.AIR, 0D);
		materialOpacity.put(Material.SAPLING, 0.3D);
		materialOpacity.put(Material.LEAVES, 0.3D);
		materialOpacity.put(Material.GLASS, 0.5D); // Double glass means UV protection :)
		materialOpacity.put(Material.YELLOW_FLOWER, 0.1D);
		materialOpacity.put(Material.RED_ROSE, 0.1D);
		materialOpacity.put(Material.BROWN_MUSHROOM, 0.1D);
		materialOpacity.put(Material.RED_MUSHROOM, 0.1D);
		materialOpacity.put(Material.TORCH, 0.1D);
		materialOpacity.put(Material.FIRE, 0D);
		materialOpacity.put(Material.MOB_SPAWNER, 0.3D);
		materialOpacity.put(Material.REDSTONE_WIRE, 0D);
		materialOpacity.put(Material.CROPS, 0.2D);
		materialOpacity.put(Material.SIGN, 0.1D);
		materialOpacity.put(Material.SIGN_POST, 0.2D);
		materialOpacity.put(Material.LEVER, 0.1D);
		materialOpacity.put(Material.STONE_PLATE, 0D);
		materialOpacity.put(Material.WOOD_PLATE, 0D);
		materialOpacity.put(Material.REDSTONE_TORCH_OFF, 0.1D);
		materialOpacity.put(Material.REDSTONE_TORCH_ON, 0.1D);
		materialOpacity.put(Material.STONE_BUTTON, 0D);
		materialOpacity.put(Material.SUGAR_CANE_BLOCK, 0.3D);
		materialOpacity.put(Material.FENCE, 0.2D);
		materialOpacity.put(Material.DIODE_BLOCK_OFF, 0D);
		materialOpacity.put(Material.DIODE_BLOCK_ON, 0D);
		
		// For each damage to the creature; how much blood will the vampire obtain
		foodPerDamageFromCreature.put(CreatureType.CHICKEN, foodPerDamageFromPlayer / 5D);
		foodPerDamageFromCreature.put(CreatureType.COW, foodPerDamageFromPlayer / 5D);
		foodPerDamageFromCreature.put(CreatureType.PIG, foodPerDamageFromPlayer / 5D);
		foodPerDamageFromCreature.put(CreatureType.SHEEP, foodPerDamageFromPlayer / 5D);
		foodPerDamageFromCreature.put(CreatureType.SPIDER, foodPerDamageFromPlayer / 10D);
		foodPerDamageFromCreature.put(CreatureType.CAVE_SPIDER, foodPerDamageFromPlayer / 10D);
		foodPerDamageFromCreature.put(CreatureType.SQUID, foodPerDamageFromPlayer / 10D);
		
		// These are the creature types that won't target vampires
		creatureTypeTruceMonsters.add(CreatureType.CREEPER);
		creatureTypeTruceMonsters.add(CreatureType.GHAST);
		creatureTypeTruceMonsters.add(CreatureType.SKELETON);
		creatureTypeTruceMonsters.add(CreatureType.SPIDER);
		creatureTypeTruceMonsters.add(CreatureType.CAVE_SPIDER);
		creatureTypeTruceMonsters.add(CreatureType.ZOMBIE);
		creatureTypeTruceMonsters.add(CreatureType.ENDERMAN);
		creatureTypeTruceMonsters.add(CreatureType.GIANT);
		
		giveThesePermissionsToVampires.put("example.vampires.should.have.this", true);
		giveThesePermissionsToVampires.put("example.this.to", true);
		giveThesePermissionsToVampires.put("example.but.negate.this", false);
		
		giveThesePermissionsToNonVampires.put("example.nonvampires.can.do.this", true);
		giveThesePermissionsToVampires.put("example.but.not.that", false);
	}
	
	
	// -------------------------------------------- //
	// Persistance
	// -------------------------------------------- //
	private static transient Conf i = new Conf();
	public static void load()
	{
		P.p.persist.loadOrSaveDefault(i, Conf.class, "conf");
	}
	public static void save()
	{
		P.p.persist.save(i);
	}
}
