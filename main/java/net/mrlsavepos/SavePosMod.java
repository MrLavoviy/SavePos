package net.mrlsavepos;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.mrlsavepos.command.PosCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SavePosMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("savepos");

	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((PosCommand::register));
	}
}