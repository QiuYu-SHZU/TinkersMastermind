package net.qiuyu.tinkersmastermind.register.item;

import net.minecraft.world.item.Item;

public class CoralCopper {
    public static Item register_item() {
        return new Item(new Item.Properties()
                .stacksTo(64));
    }
}
