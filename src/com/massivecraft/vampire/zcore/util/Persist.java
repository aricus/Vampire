package com.massivecraft.vampire.zcore.util;

import java.io.File;
import java.lang.reflect.Type;
import java.util.logging.Level;

import com.massivecraft.vampire.zcore.MPlugin;

// TODO: Give better name and place to differenciate from the entity-orm-ish system in "com.massivecraft.core.persist".

public class Persist {
	
	private MPlugin p;
	public Persist(MPlugin p)
	{
		this.p = p;
	}
	
	// ------------------------------------------------------------ //
	// GET NAME - What should we call this type of object?
	// ------------------------------------------------------------ //
	
	public static String getName(Class<?> clazz)
	{
		return clazz.getSimpleName().toLowerCase();
	}
	
	public static String getName(Object o)
	{
		return getName(o.getClass());
	}
	
	public static String getName(Type type)
	{
		return getName(type.getClass());
	}
	
	// ------------------------------------------------------------ //
	// GET FILE - In which file would we like to store this object? 
	// ------------------------------------------------------------ //
	
	public File getFile(String name)
	{
		return new File(p.getDataFolder(), name+".json");
	}
	
	public File getFile(Class<?> clazz)
	{
		return getFile(getName(clazz));
	}
	
	public File getFile(Object obj)
	{
		return getFile(getName(obj));
	}
	
	public File getFile(Type type)
	{
		return getFile(getName(type));
	}
	
	
	// NICE WRAPPERS
	
	public <T> T loadOrSaveDefault(T def, Class<T> clazz)
	{
		return loadOrSaveDefault(def, clazz, getFile(clazz));
	}
	
	public <T> T loadOrSaveDefault(T def, Class<T> clazz, String name)
	{
		return loadOrSaveDefault(def, clazz, getFile(name));
	}
	
	public <T> T loadOrSaveDefault(T def, Class<T> clazz, File file)
	{
		if ( ! file.exists())
		{
			p.log("Creating default: "+file);
			this.save(def, file);
			return def;
		}
		
		T loaded = this.load(clazz, file);
		
		if (loaded == null)
		{
			p.log(Level.WARNING, "Using default as I failed to load: "+file);
			return def;
		}
		
		return loaded;
	}
	
	// SAVE
	
	public boolean save(Object instance)
	{
		return save(instance, getFile(instance));
	}
	
	public boolean save(Object instance, String name)
	{
		return save(instance, getFile(name));
	}
	
	public boolean save(Object instance, File file)
	{
		return DiscUtil.writeCatch(file, p.gson.toJson(instance));
	}
	
	// LOAD BY CLASS
	
	public <T> T load(Class<T> clazz)
	{
		return load(clazz, getFile(clazz));
	}
	
	public <T> T load(Class<T> clazz, String name)
	{
		return load(clazz, getFile(name));
	}
	
	public <T> T load(Class<T> clazz, File file)
	{
		String content = DiscUtil.readCatch(file);
		if (content == null)
		{
			return null;
		}
		
		T instance = p.gson.fromJson(content, clazz);
		
		return instance;
	}
	
	
	// LOAD BY TYPE
	public <T> T load(Type typeOfT, String name)
	{
		return load(typeOfT, getFile(name));
	}
	
	public <T> T load(Type typeOfT, File file)
	{
		String content = DiscUtil.readCatch(file);
		if (content == null) {
			return null;
		}
		
		return p.gson.fromJson(content, typeOfT);
	}
	
}
