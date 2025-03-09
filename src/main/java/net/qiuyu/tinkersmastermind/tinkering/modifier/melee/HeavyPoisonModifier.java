package net.qiuyu.tinkersmastermind.tinkering.modifier.melee;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class HeavyPoisonModifier extends Modifier implements MeleeHitModifierHook {
    private final ResourceLocation KEY = new ResourceLocation("tinkersmastermind", "heavy_poison");

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MELEE_HIT);
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        // 根据工具等级赋予对方1/2级的中毒效果
        int level = modifier.getLevel();
        LivingEntity target = context.getLivingTarget();
        if (target != null && !target.isDeadOrDying())
            context.getLivingTarget().addEffect(new MobEffectInstance(MobEffects.POISON, 20 * (1 + level), level / 2));
    }
}
