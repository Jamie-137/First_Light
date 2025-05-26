package io.github.jamie137.first_light;

import io.github.jamie137.first_light.block.FirstLightBlocks;
import io.github.jamie137.first_light.item.FirstLightGroups;
import io.github.jamie137.first_light.item.FirstLightItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class First_light implements ModInitializer {
    public static final String MOD_ID = "first_light";
    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        FirstLightGroups.registerItemGroups();

        FirstLightItems.registerModItems();
        FirstLightBlocks.registerModBlocks();

    }
}
