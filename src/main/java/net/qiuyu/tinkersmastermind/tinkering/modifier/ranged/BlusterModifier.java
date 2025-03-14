package net.qiuyu.tinkersmastermind.tinkering.modifier.ranged;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.EntityBasedExplosionDamageCalculator;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.common.util.Lazy;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;

import javax.annotation.Nullable;

public class BlusterModifier extends Modifier implements ProjectileHitModifierHook {
    private final ResourceLocation KEY = new ResourceLocation("tinkersmastermind", "bluster");

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
//        hookBuilder.addHook(this, ModifierHooks.PROJECTILE_HIT);
    }
    @Override
    public boolean onProjectileHitBlock(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, BlockHitResult hit, @Nullable LivingEntity attacker) {
        // 接触到方块时产生范围为6.5格,不破坏方块的爆炸,,3级会额外附着火焰
        boolean canFire = false;
        if (modifier.getLevel() > 2) {
            canFire = true;
        }
        Entity source = projectile;
        projectile.level().explode(projectile.getOwner(),null,new EntityBasedExplosionDamageCalculator(projectile)
                ,hit.getLocation().x(),hit.getLocation().y(),hit.getLocation().z(),
                2.0f + modifier.getLevel(),canFire, Level.ExplosionInteraction.TNT,false);
        // 生成粒子
//        projectile.level().addParticle();
        // 播放声音
        projectile.level().playSound(null,hit.getBlockPos(), SoundEvents.GENERIC_EXPLODE, SoundSource.HOSTILE, 0.3f * modifier.getLevel(), 1.0f);
        return true;
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        // 接触到方块时产生范围为6.5格,不破坏方块的爆炸,3级会额外附着火焰
        boolean canFire = false;
        if (modifier.getLevel() > 2) {
            canFire = true;
        }
        // 如果命中目标为存活玩家,则施加10秒2级的混乱效果
        projectile.level().explode(projectile.getOwner(),null,new EntityBasedExplosionDamageCalculator(projectile)
                ,hit.getLocation().x(),hit.getLocation().y(),hit.getLocation().z(),
                2.0f + modifier.getLevel(),canFire, Level.ExplosionInteraction.TNT,false);
        projectile.level().playSound(null,projectile.getOnPos(), SoundEvents.GENERIC_EXPLODE, SoundSource.HOSTILE, 0.3f * modifier.getLevel(), 1.0f);
        if (target instanceof Player && !target.isDeadOrDying()){
            target.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 1));
        }
        return true;
    }
}
