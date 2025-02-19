package net.qiuyu.tinkersmastermind.datagen;


import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.qiuyu.tinkersmastermind.TinkersMastermind;


@Mod.EventBusSubscriber(modid = TinkersMastermind.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

//        generator.addProvider(new ModItemModelGen(generator, helper));
//        generator.addProvider(new ModLangGenEN(generator, "en_us"));
//        generator.addProvider(new ModLangGenCN(generator, "zh_cn"));


    }
}