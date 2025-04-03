package net.qiuyu.tinkersmastermind.tinkering.modifier.ranged;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.DamageDealtModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;


public class DoubleShotModifier extends Modifier implements DamageDealtModifierHook {
    private final ResourceLocation KEY = new ResourceLocation("tinkersmastermind", "double_shot");

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.DAMAGE_DEALT);
    }

    @Override
    public void onDamageDealt(IToolStackView iToolStackView, ModifierEntry modifierEntry, EquipmentContext context, EquipmentSlot equipmentSlot, LivingEntity entity, DamageSource damageSource, float damage, boolean b) {
        if (entity.isAlive()){
            boolean previous = entity.isInvulnerable();
            entity.setInvulnerable(true);
            entity.hurt(damageSource,damage);
            entity.setInvulnerable(previous);
        }
    }
}
