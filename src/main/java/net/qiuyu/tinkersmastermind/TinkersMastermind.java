package net.qiuyu.tinkersmastermind;


import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.qiuyu.tinkersmastermind.creativetabs.TinkersMastermindItemGroup;
import net.qiuyu.tinkersmastermind.creativetabs.TinkersMastermindToolGroup;
import net.qiuyu.tinkersmastermind.recipe.ModRecipes;
import net.qiuyu.tinkersmastermind.register.TinkersMastermindEffect;
import net.qiuyu.tinkersmastermind.register.TinkersMastermindItems;
import net.qiuyu.tinkersmastermind.register.TinkersMastermindModifiers;

@Mod(TinkersMastermind.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TinkersMastermind {
    public static final String MOD_ID = "tinkersmastermind";
    public static final CreativeModeTab itemGroup = new TinkersMastermindItemGroup();
    public static final CreativeModeTab toolGroup = new TinkersMastermindToolGroup();

    public TinkersMastermind() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TinkersMastermindConfig.config);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        TinkersMastermindItems.ITEMS.register(bus);
        TinkersMastermindModifiers.MODIFIERS.register(bus);
        TinkersMastermindEffect.EFFECTS.register(bus);
        ModRecipes.register(bus);


    }

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

    }
}
