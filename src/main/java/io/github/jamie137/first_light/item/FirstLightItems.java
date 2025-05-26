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

import java.util.function.Function;

public class FirstLightItems {

    public static final Item LIGHT_SHARD = registerItem("light_shard", Item::new);
    public static final Item DARK_CRUX = registerItem("dark_crux", Item::new);

    public static final Item CHARGED_CRUX = registerItem("charged_crux", ChargedCruxItem::new);


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(First_light.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(First_light.MOD_ID, name)))));
    }

    public static void registerModItems() {
        First_light.LOGGER.info("registering items for" + First_light.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(DARK_CRUX);
            fabricItemGroupEntries.add(LIGHT_SHARD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(CHARGED_CRUX);
        });
    }
}
