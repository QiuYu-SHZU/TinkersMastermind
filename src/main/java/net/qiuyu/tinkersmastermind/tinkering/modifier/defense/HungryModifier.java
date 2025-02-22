package net.qiuyu.tinkersmastermind.tinkering.modifier.defense;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.ModifyDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nullable;
import java.util.List;

public class HungryModifier extends Modifier implements ModifyDamageModifierHook, TooltipModifierHook {
    private static final Logger LOGGER = LoggerFactory.getLogger(HungryModifier.class);
    private final ResourceLocation KEY = new ResourceLocation("tinkersmastermind", "hungry");
    public int getPriority() {
        return 90;
    }
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MODIFY_DAMAGE, ModifierHooks.TOOLTIP);
    }
    @Override
    public float modifyDamageTaken(IToolStackView stackView, ModifierEntry entry, EquipmentContext context, EquipmentSlot slot, DamageSource source, float v, boolean b) {
        Level world = context.getEntity().level();
        Entity entity = context.getEntity();
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ()
                        , SoundEvents.ZOMBIE_HURT, SoundSource.HOSTILE, 0.3F * entry.getLevel()
                        , 1.0F + (world.random.nextFloat() - world.random.nextFloat()) * 0.4F);
//        穿戴者受到攻击时 获得1/2/2.5格(即2/4/5点)的饱食度回复(与0.8/1.6/2点饱和) CD 0.5s 根据1/2/3级触发概率为20％/40％/60％=
        if (RANDOM.nextInt(10) < entry.getLevel() * 2 && context.getEntity() instanceof Player) {
            int level = entry.getLevel();
            ((Player)context.getEntity()).getFoodData().eat(2 * level, 0.8f * level);
        }
        return v;
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        //        穿戴者会获得饥饿效果 第1/2/3级时分别带来饥饿1/2/3级效果
        if (player != null && player.getEffect(MobEffects.HUNGER) == null) {
            int level = modifierEntry.getLevel();
            player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, level-1, true, true));
        }
    }
}
