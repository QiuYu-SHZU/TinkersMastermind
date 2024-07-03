package net.qiuyu.tinkersmastermind.modifiers;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
import net.qiuyu.tinkersmastermind.register.TinkersMastermindEffect;
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

public class FlameCoatingModifier extends Modifier implements MeleeHitModifierHook, ProjectileHitModifierHook {

    private final ResourceLocation KEY = new ResourceLocation("tinkersmastermind", "flame_coating");

    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.MELEE_HIT);
        hookBuilder.addHook(this, TinkerHooks.PROJECTILE_HIT);
    }
    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        int level = modifier.getLevel();
        LivingEntity target = context.getLivingTarget();
        if (target != null && !target.fireImmune()) {
            if (level == 1) {
                if (!target.isOnFire()) {
                    target.setSecondsOnFire(3);
                } else {
                    target.hurt(DamageSource.MAGIC, 2.0F);
                }
            }
            if (level == 2) {
                target.setSecondsOnFire(9999);
            }
            if (level == 3) {
                if (!target.isOnFire()) {
                    target.setSecondsOnFire(9999);
                } else {
                    target.removeEffect(TinkersMastermindEffect.NO_HEAL.get());
                    target.addEffect(new MobEffectInstance(TinkersMastermindEffect.NO_HEAL.get(), 200));
                }
            }
        }
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        int level = modifier.getLevel();
        if (target != null && !target.fireImmune()) {
            if (level == 1) {
                if (!target.isOnFire()) {
                    target.setSecondsOnFire(3);
                } else {
                    target.hurt(DamageSource.MAGIC, 2.0F);
                }
            }
            if (level == 2) {
                target.setSecondsOnFire(9999);
            }
            if (level == 3) {
                if (!target.isOnFire()) {
                    target.setSecondsOnFire(9999);
                } else {
                    target.removeEffect(TinkersMastermindEffect.NO_HEAL.get());
                    target.addEffect(new MobEffectInstance(TinkersMastermindEffect.NO_HEAL.get(), 200));
                }
            }
        }
        return false;
    }
}
