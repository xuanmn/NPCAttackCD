package com.ezInferno;

//import com.ezInferno.ezInfernoPlugin;
import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ezInfernoPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(ezInfernoPlugin.class);
		RuneLite.main(args);
	}
}