package net.qiuyu.tinkersmastermind.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.qiuyu.tinkersmastermind.TinkersMastermind;


public class ModBlockModelGen extends BlockStateProvider {
    public ModBlockModelGen(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, TinkersMastermind.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }

//
//    @Override
//    protected void registerStatesAndModels() {
//        // 在这里注册方块的状态和模型
//        this.registerBlockModelAndItem(TinkersMastermindBlocks.ZIRCON_BLOCK.get());
//    }
//
//    public void registerBlockModelAndItem(Block block){
//        // cubeAll()为六个面相同时可以调用的办法
//        this.simpleBlockWithItem(block,this.cubeAll(block));
//    }
}
