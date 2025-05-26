package io.github.jamie137.first_light.item;

import io.github.jamie137.first_light.First_light;
import io.github.jamie137.first_light.item.custom.ChargedCruxItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class FirstLightItems {

    public static final Item LIGHT_SHARD = registerItem("light_shard", new Item.Settings());
    public static final Item DARK_CRUX = registerItem("dark_crux", new Item.Settings());

    public static final Item CHARGED_CRUX = registerItem("charged_crux", new ChargedCruxItem(new Item.Settings()));

    private static Item registerItem(String name, Item.Settings itemSettings) {
        Identifier id = Identifier.of(First_light.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = itemSettings.registryKey(key);

        return Registry.register(Registries.ITEM, key, new Item(settings));
    }

    public static void registerModItems() {
        First_light.LOGGER.info("registering items for" + First_light.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(DARK_CRUX);
            fabricItemGroupEntries.add(LIGHT_SHARD);
        });
    }
}
