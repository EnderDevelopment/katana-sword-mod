package com.example.katanamod.init;

import com.example.katanamod.item.KatanaSwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "katanamod");

    public static final RegistryObject<Item> KATANA_SWORD = ITEMS.register("katana_sword", () -> new KatanaSwordItem(Tiers.IRON, 3, -2.4F, new Item.Properties().tab(ModCreativeModeTab.KATANA_TAB)));
}