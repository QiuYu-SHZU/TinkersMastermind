package net.qiuyu.tinkersmastermind.register;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.qiuyu.tinkersmastermind.register.item.ZombieIron;

import static net.qiuyu.tinkersmastermind.TinkersMastermind.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    private static final Item.Properties TOOL = new Item.Properties().stacksTo(1);
    private static final Item.Properties PARTS_PROPS = new Item.Properties();

    public static RegistryObject<Item> zombie_iron = ITEMS.register("zombie_iron", ZombieIron::register_item);


    public static BlockItem register_block(Block block) {
        return new BlockItem(block, new Item.Properties());
    }

    public static Item register_item() {
        return new Item(new Item.Properties());
    }


}
