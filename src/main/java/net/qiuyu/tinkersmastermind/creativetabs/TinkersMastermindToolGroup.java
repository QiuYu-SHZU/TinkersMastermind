package net.qiuyu.tinkersmastermind.creativetabs;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.qiuyu.tinkersmastermind.register.TinkersMastermindItems;

public class TinkersMastermindToolGroup extends CreativeModeTab {


    public TinkersMastermindToolGroup() {
        super("TinkersMastermindToolGroup");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(TinkersMastermindItems.poison_coating_lvl1.get());
    }
}
