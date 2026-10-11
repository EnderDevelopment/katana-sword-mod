package com.example.katanamod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class KatanaSwordItem extends SwordItem {
    public KatanaSwordItem(Tier tier, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level world = attacker.level;
        if (!world.isClientSide) {
            if (target instanceof CowEntity || target instanceof PigEntity) {
            if (stack.getDamageValue() < stack.getMaxDamage() - 1) {
                stack.setDamageValue(stack.getDamageValue() + 1);
                world.playSound(null, target.blockPosition(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
                if (world instanceof ServerLevel) {
                    ((ServerLevel) world).sendParticles(ParticleTypes.LAVA, target.getX(), target.getY(), target.getZ(), 10, 0.1, 0.1, 0.1, 0.1);
                }
            }
        } else if (target instanceof ZombieEntity) {
            if (stack.getDamageValue() < stack.getMaxDamage() - 2) {
                stack.setDamageValue(stack.getDamageValue() + 2);
                world.playSound(null, target.blockPosition(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
                if (world instanceof ServerLevel) {
                    ((ServerLevel) world).sendParticles(ParticleTypes.LAVA, target.getX(), target.getY(), target.getZ(), 10, 0.1, 0.1, 0.1, 0.1);
                }
            }
        }
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}