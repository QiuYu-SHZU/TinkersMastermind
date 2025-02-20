package net.qiuyu.tinkersmastermind.fluids;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.qiuyu.tinkersmastermind.TinkersMastermind;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FlowingFluidObject;

import static slimeknights.tconstruct.fluids.block.BurningLiquidBlock.createBurning;
import static slimeknights.tconstruct.fluids.block.MobEffectLiquidBlock.createEffect;

public class ModFluids  {
    protected static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(TinkersMastermind.MOD_ID);
    public static final FlowingFluidObject<ForgeFlowingFluid> molten_zombie_iron = FLUIDS.register("molten_zombie_iron").type(hot().temperature(1000).lightLevel(15)).block(createBurning(MapColor.COLOR_GREEN, 10, 10,2)).bucket().flowing();
//    public static final FlowingFluidObject<ForgeFlowingFluid> reburn_ashes   = FLUIDS.register("reburn_ashes").type(hot().temperature(1500).lightLevel(15)).block(createBurning(15, 10, 9f)).bucket().flowing();
//    public static final FlowingFluidObject<ForgeFlowingFluid> molten_echo  = FLUIDS.register("molten_echo").type(common().temperature(50).lightLevel(3)).block(createEffect(3, () -> new MobEffectInstance(MobEffects.DARKNESS, 100))).bucket().flowing();
//    public static final FlowingFluidObject<ForgeFlowingFluid> syrup  = FLUIDS.register("syrup").type(common().temperature(75).lightLevel(15)).block(createEffect(7, () -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100))).bucket().flowing();
//    public static final FlowingFluidObject<ForgeFlowingFluid> molten_cocoa  = FLUIDS.register("molten_cocoa").type(hot().temperature(100).lightLevel(7)).block(createEffect(7, () -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100))).bucket().flowing();
//    public static final FlowingFluidObject<ForgeFlowingFluid> molten_black_chocolate  = FLUIDS.register("molten_black_chocolate").type(hot().temperature(90).lightLevel(7)).block(createEffect(7, () -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100))).bucket().flowing();
//    public static final FlowingFluidObject<ForgeFlowingFluid> molten_white_chocolate  = FLUIDS.register("molten_white_chocolate").type(hot().temperature(80).lightLevel(7)).block(createEffect(7, () -> new MobEffectInstance(MobEffects.DIG_SPEED, 100))).bucket().flowing();
    private static FluidType.Properties common() {
       return FluidType.Properties.create().density(2000).viscosity(10000).temperature(1000).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                .motionScale(0.0023333333333333335D)
                .canExtinguish(true);
    }
    private static FluidType.Properties hot() {
        return FluidType.Properties.create().density(2000).viscosity(10000).temperature(1000)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                .motionScale(0.0023333333333333335D)
                .canSwim(false).canDrown(false)
                .pathType(BlockPathTypes.LAVA).adjacentPathType(null);
    }
}
