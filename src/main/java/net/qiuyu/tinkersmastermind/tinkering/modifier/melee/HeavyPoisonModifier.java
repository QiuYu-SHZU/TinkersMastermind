package net.qiuyu.tinkersmastermind.tinkering.modifier.melee;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.qiuyu.tinkersmastermind.register.ModEffects;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class HeavyPoisonModifier extends Modifier implements MeleeHitModifierHook, MeleeDamageModifierHook {
    private final ResourceLocation KEY = new ResourceLocation("tinkersmastermind", "heavy_poison");

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MELEE_HIT, ModifierHooks.MELEE_DAMAGE);
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        // 根据工具等级赋予对方1/2级的中毒效果
        int level = modifier.getLevel();
        LivingEntity target = context.getLivingTarget();
        if (target != null && !target.isDeadOrDying() && context.isFullyCharged())
            context.getLivingTarget().addEffect(new MobEffectInstance(MobEffects.POISON, 100, level - 1));
    }

    @Override
    public float getMeleeDamage(IToolStackView view, ModifierEntry entry, ToolAttackContext context, float v, float v1) {
        //  如果攻击时身上有中毒效果,则根据中毒剩余时间增加造成的伤害,最高20％  每3秒1％(也就是一分钟为最大值).
        float amplifier = 1F;
        LivingEntity attacker = context.getAttacker();
        if (attacker.hasEffect(MobEffects.POISON)){
           amplifier += (float)attacker.getEffect(MobEffects.POISON).getDuration() % 1200 / 1200;
        }
        return v * amplifier;
    }
}
