package net.qiuyu.tinkersmastermind.register.block;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class ZombieIronBlock {
    public static Block register_block() {
        return new Block(Block.Properties.of()
                .sound(SoundType.METAL)
                .strength(2F)
        );
    }
}
