package net.qiuyu.tinkersmastermind.register;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.qiuyu.tinkersmastermind.TinkersMastermind;
import net.qiuyu.tinkersmastermind.tinkering.modifier.defense.HungryModifier;
import net.qiuyu.tinkersmastermind.tinkering.modifier.defense.PoisonSparkleModifier;
import net.qiuyu.tinkersmastermind.tinkering.modifier.melee.HeavyPoisonModifier;
import net.qiuyu.tinkersmastermind.tinkering.modifier.melee.RottenModifier;
import net.qiuyu.tinkersmastermind.tinkering.modifier.ranged.BlusterModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class ModModifiers {
    public static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersMastermind.MOD_ID);
    public ModModifiers() {
        MODIFIERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final StaticModifier<RottenModifier> Rotten = MODIFIERS.register("rotten", RottenModifier::new);
    public static final StaticModifier<HungryModifier> Hungry = MODIFIERS.register("hungry", HungryModifier::new);
    public static final StaticModifier<BlusterModifier> Bluster = MODIFIERS.register("bluster", BlusterModifier::new);
    public static final StaticModifier<PoisonSparkleModifier> PoisonSparkle = MODIFIERS.register("poison_sparkle", PoisonSparkleModifier::new);
    public static final StaticModifier<HeavyPoisonModifier> HeavyPoison = MODIFIERS.register("heavy_poison", HeavyPoisonModifier::new);

}
