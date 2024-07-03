package net.qiuyu.tinkersmastermind.modifiers;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;

public class PoisonCoatingModifier extends Modifier implements MeleeHitModifierHook, ProjectileHitModifierHook {

    private final ResourceLocation KEY = new ResourceLocation("tinkersmastermind", "poison_coating");

    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.MELEE_HIT);
        hookBuilder.addHook(this, TinkerHooks.PROJECTILE_HIT);
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        if (target != null) {
            int level = modifier.getLevel();
            if (target.hasEffect(MobEffects.POISON)) {
                int durationTime = target.getEffect(MobEffects.POISON).getDuration() + 60;
                if (level == 1) {
                    target.addEffect(new MobEffectInstance(MobEffects.POISON, durationTime, 0));
                }
                if (level == 2) {
                    if (durationTime >= 200 && target.getEffect(MobEffects.POISON).getAmplifier() == 0) {
                        target.removeEffect(MobEffects.POISON);
                        target.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 1));
                    } else {
                        target.addEffect(new MobEffectInstance(MobEffects.POISON, durationTime, target.getEffect(MobEffects.POISON).getAmplifier()));
                    }
                }
                if (level == 3) {
                    if (durationTime >= 200 && target.getEffect(MobEffects.POISON).getAmplifier() == 2) {
                        target.removeEffect(MobEffects.POISON);
                        target.hurt(DamageSource.MAGIC, 33.0F);
                    } else {
                        if (durationTime >= 200) {
                            target.addEffect(new MobEffectInstance(MobEffects.POISON, 60, target.getEffect(MobEffects.POISON).getAmplifier() + 1));
                        } else {
                            target.addEffect(new MobEffectInstance(MobEffects.POISON, durationTime, target.getEffect(MobEffects.POISON).getAmplifier()));
                        }
                    }
                }
            } else {
                target.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0));
            }
        }
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        if (target != null) {
            int level = modifier.getLevel();
            if (target.hasEffect(MobEffects.POISON)) {
                int durationTime = target.getEffect(MobEffects.POISON).getDuration() + 60;
                if (level == 1) {
                    target.addEffect(new MobEffectInstance(MobEffects.POISON, durationTime, 0));
                }
                if (level == 2) {
                    if (durationTime >= 200 && target.getEffect(MobEffects.POISON).getAmplifier() == 0) {
                        target.removeEffect(MobEffects.POISON);
                        target.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 1));
                    } else {
                        target.addEffect(new MobEffectInstance(MobEffects.POISON, durationTime, target.getEffect(MobEffects.POISON).getAmplifier()));
                    }
                }
                if (level == 3) {
                    if (durationTime >= 200 && target.getEffect(MobEffects.POISON).getAmplifier() == 2) {
                        target.removeEffect(MobEffects.POISON);
                        target.hurt(DamageSource.MAGIC, 33.0F);
                    } else {
                        if (durationTime >= 200) {
                            target.addEffect(new MobEffectInstance(MobEffects.POISON, 60, target.getEffect(MobEffects.POISON).getAmplifier() + 1));
                        } else {
                            target.addEffect(new MobEffectInstance(MobEffects.POISON, durationTime, target.getEffect(MobEffects.POISON).getAmplifier()));
                        }
                    }
                }
            } else {
                target.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0));
            }
        }
        return false;
    }
}
