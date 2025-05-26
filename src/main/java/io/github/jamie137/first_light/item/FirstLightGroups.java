package io.github.jamie137.first_light.item;

import io.github.jamie137.first_light.First_light;
import io.github.jamie137.first_light.block.FirstLightBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class FirstLightGroups {

    public static final ItemGroup FIRST_LIGHT_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(First_light.MOD_ID, "first_light_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(FirstLightItems.DARK_CRUX))
                    .displayName(Text.translatable("itemgroup.first_light.first_light_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(FirstLightItems.LIGHT_SHARD);
                        entries.add(FirstLightItems.DARK_CRUX);
                        entries.add(FirstLightItems.CHARGED_CRUX);
                    }).build());

    public static final ItemGroup FIRST_LIGHT_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(First_light.MOD_ID, "first_light_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(FirstLightBlocks.CRUX_BLOCK))
                    .displayName(Text.translatable("itemgroup.first_light.first_light_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(FirstLightBlocks.CRUX_BLOCK);
                        entries.add(FirstLightBlocks.LIGHT_SHARD_BLOCK );
                    }).build());

    public static void registerItemGroups() {
        First_light.LOGGER.info("Registering creative tabs for" + First_light.MOD_ID);
    }
}
