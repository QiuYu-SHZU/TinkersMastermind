package net.qiuyu.tinkersmastermind.creativetabs;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.qiuyu.tinkersmastermind.register.TinkersMastermindItems;

public class TinkersMastermindItemGroup extends CreativeModeTab {

    public TinkersMastermindItemGroup() {
        super("TinkersMastermindItemGroup");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(TinkersMastermindItems.poison_coating_lvl1.get());
    }
}
