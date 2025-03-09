package net.qiuyu.tinkersmastermind.tinkering.modifier.defense;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.OnAttackedModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Random;

public class PoisonSparkleModifier extends Modifier implements OnAttackedModifierHook {
    private final ResourceLocation KEY = new ResourceLocation("tinkersmastermind", "poison_sparkle");

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.ON_ATTACKED);
    }

    @Override
    public void onAttacked(IToolStackView iToolStackView, ModifierEntry modifierEntry, EquipmentContext equipmentContext, EquipmentSlot equipmentSlot, DamageSource damageSource, float v, boolean b) {
        Entity attacker = damageSource.getEntity();
        int level = modifierEntry.getLevel();
        if (attacker instanceof LivingEntity && attacker.isAlive()) {
            // 有10％/20％/30％/40％的概率使敌人获得中毒II效果
//            attacker.hurt(damageSource, 0.5F * (level + 1));
            Random random = new Random();
            if (random.nextFloat() < 0.1 * level) {
                ((LivingEntity) attacker).addEffect(new MobEffectInstance(MobEffects.POISON, 20 * (1 + modifierEntry.getLevel()), 1));
            }
        }
    }
}
