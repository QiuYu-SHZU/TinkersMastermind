package net.qiuyu.tinkersmastermind.register;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.qiuyu.tinkersmastermind.TinkersMastermind.*;

public class TinkersMastermindItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    private static final Item.Properties TOOL = new Item.Properties().stacksTo(1).tab(toolGroup);
    private static final Item.Properties PARTS_PROPS = new Item.Properties().tab(toolGroup);

    // potions

    public static RegistryObject<Item> sticky_potion = ITEMS.register("sticky_potion", TinkersMastermindItems::register_item);
    public static RegistryObject<Item> poison_coating_lvl1 = ITEMS.register("poison_coating_lvl1", TinkersMastermindItems::register_item);
    public static RegistryObject<Item> poison_coating_lvl2 = ITEMS.register("poison_coating_lvl2", TinkersMastermindItems::register_item);
    public static RegistryObject<Item> poison_coating_lvl3 = ITEMS.register("poison_coating_lvl3", TinkersMastermindItems::register_item);


    public static BlockItem register_block(Block block) {
        return new BlockItem(block, new Item.Properties().tab(itemGroup));
    }

    public static Item register_item() {
        return new Item(new Item.Properties().tab(itemGroup));
    }


}
