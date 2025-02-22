package net.qiuyu.tinkersmastermind.tinkering.modifier.melee;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.common.util.Lazy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ProcessLootModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.GeneralInteractionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InteractionSource;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import java.util.List;



public class RottenModifier extends Modifier implements ProcessLootModifierHook,GeneralInteractionModifierHook {

    private static final Logger log = LoggerFactory.getLogger(RottenModifier.class);
    private final ResourceLocation KEY = new ResourceLocation("tinkersmastermind", "rotten");
    private static final Lazy<ItemStack> ROTTEN_FLESH_STACK = Lazy.of(() -> new ItemStack(Items.ROTTEN_FLESH));

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.PROCESS_LOOT, ModifierHooks.GENERAL_INTERACT);
    }

    @Override
    public void processLoot(IToolStackView tool, ModifierEntry modifier, List<ItemStack> generatedLoot, LootContext context) {
        // if no damage source, probably not a mob
        // otherwise blocks breaking (where THIS_ENTITY is the player) start dropping bacon
        if (!context.hasParam(LootContextParams.DAMAGE_SOURCE)) {
            return;
        }

        // must have an entity
        Entity entity = context.getParamOrNull(LootContextParams.THIS_ENTITY);
        if (entity != null ) {
            // 固定50%的几率掉落腐肉,不受等级影响
            if (RANDOM.nextInt(2) == 0) {
                generatedLoot.add(ROTTEN_FLESH_STACK.get());
            }
        }
    }

    @Override
    public InteractionResult onToolUse(IToolStackView tool, ModifierEntry modifier, Player player, InteractionHand hand, InteractionSource source) {
        if (source == InteractionSource.RIGHT_CLICK && !tool.isBroken() && player.canEat(false)) {
            GeneralInteractionModifierHook.startUsing(tool, modifier.getId(), player, hand);
            log.info("RottenModifier StartToolUse");
            eat(tool, modifier, player);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }

    private void eat(IToolStackView tool, ModifierEntry modifier, LivingEntity entity) {
        int level = modifier.intEffectiveLevel();
        if (level > 0 && entity instanceof Player player && player.canEat(false)) {
            Level world = entity.level();
            log.info("RottenModifier Eating");

            player.getFoodData().eat(level, 0.4F);
            ModifierUtil.foodConsumer.onConsume(player, ROTTEN_FLESH_STACK.get(), level, 0.8F);
            player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 40, 0));

            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_EAT, SoundSource.NEUTRAL, 1.0F, 1.0F + (world.random.nextFloat() - world.random.nextFloat()) * 0.4F);
            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_BURP, SoundSource.NEUTRAL, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);

            // 15 damage for a bite per level, does not process reinforced/overslime, your teeth are tough
            if (ToolDamageUtil.directDamage(tool, 15 * level, player, player.getUseItem())) {
                player.broadcastBreakEvent(player.getUsedItemHand());
            }
            log.info("RottenModifier Eaten");
        }
    }
}
