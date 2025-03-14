package net.qiuyu.tinkersmastermind.effects;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PosionResistEffect extends BaseEffect{

    public PosionResistEffect(MobEffectCategory type, int color, boolean isInstant) {
        super(type, color, isInstant);
    }
    public PosionResistEffect(){
        super(MobEffectCategory.BENEFICIAL, 0x660033, false);
    }

    @Override
    protected boolean canApplyEffect(int remainingTicks, int level) {
        return true;
    }
}
