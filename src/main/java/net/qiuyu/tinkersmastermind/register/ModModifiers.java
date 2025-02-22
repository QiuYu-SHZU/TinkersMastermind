package net.qiuyu.tinkersmastermind.register;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.qiuyu.tinkersmastermind.TinkersMastermind;
import net.qiuyu.tinkersmastermind.tinkering.modifier.defense.HungryModifier;
import net.qiuyu.tinkersmastermind.tinkering.modifier.melee.RottenModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class ModModifiers {
    public static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersMastermind.MOD_ID);
    public ModModifiers() {
        MODIFIERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final StaticModifier<RottenModifier> Rotten = MODIFIERS.register("rotten", RottenModifier::new);
    public static final StaticModifier<HungryModifier> Hungry = MODIFIERS.register("hungry", HungryModifier::new);

}
