package io.github.jamie137.first_light.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

public class ChargedCruxItem extends Item {
    public ChargedCruxItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {

        if (slot == EquipmentSlot.OFFHAND) {
            if (!entity.isOnGround()) {
                
            }
        }

        super.inventoryTick(stack, world, entity, slot);
    }
}
