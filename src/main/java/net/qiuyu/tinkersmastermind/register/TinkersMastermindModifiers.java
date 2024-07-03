package net.qiuyu.tinkersmastermind.register;

import net.qiuyu.tinkersmastermind.modifiers.FlameCoatingModifier;
import net.qiuyu.tinkersmastermind.modifiers.PoisonCoatingModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

import static net.qiuyu.tinkersmastermind.TinkersMastermind.MOD_ID;

public class TinkersMastermindModifiers {
    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(MOD_ID);
    public static StaticModifier<PoisonCoatingModifier> poison_coating = MODIFIERS.register("poison_coating", PoisonCoatingModifier::new);
    public static StaticModifier<FlameCoatingModifier> flame_coating = MODIFIERS.register("flame_coating", FlameCoatingModifier::new);
}
