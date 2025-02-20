package net.qiuyu.tinkersmastermind.register;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.qiuyu.tinkersmastermind.register.block.ZombieIronBlock;
import net.qiuyu.tinkersmastermind.register.item.ZombieIron;

import static net.qiuyu.tinkersmastermind.TinkersMastermind.MOD_ID;

public class TinkersMastermindBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static RegistryObject<Block> ZOMBIE_IRON_BLOCK = BLOCKS.register("zombie_iron_block", ZombieIronBlock::register_block);


    public static BlockItem register_block(Block block) {
        return new BlockItem(block, new Item.Properties());
    }

    public static Item register_item() {
        return new Item(new Item.Properties());
    }

}
