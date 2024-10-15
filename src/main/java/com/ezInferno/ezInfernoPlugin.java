package com.ezInferno;

import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Easy Inferno"
)
public class ezInfernoPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private com.ezInferno.ezInfernoPluginConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("InfernoPlugin started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("InfernoPlugin stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "InfernoPlugin says " + config.greeting(), null);
		}
	}

	@Provides
	com.ezInferno.ezInfernoPluginConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(com.ezInferno.ezInfernoPluginConfig.class);
	}
}
