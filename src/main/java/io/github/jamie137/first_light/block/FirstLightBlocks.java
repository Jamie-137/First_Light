package io.github.jamie137.first_light.block;

import io.github.jamie137.first_light.First_light;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class FirstLightBlocks {
    public static final Block LIGHT_SHARD_BLOCK = registerBlock("light_shard_block", AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.TUFF)
            .requiresTool()
            .strength(1.5F, 6.0F));

    public static final Block CRUX_BLOCK = registerBlock("crux_block",AbstractBlock.Settings.create()
            .strength(-1.0F, 3600000.0F)
            .dropsNothing()
            .sounds(BlockSoundGroup.STONE)
            .allowsSpawning(Blocks::never));

    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {

        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(First_light.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {

        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(First_light.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks(){
        First_light.LOGGER.info("registering blocks for" + First_light.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(FirstLightBlocks.CRUX_BLOCK);
            fabricItemGroupEntries.add(FirstLightBlocks.LIGHT_SHARD_BLOCK);
        });
    }
}
