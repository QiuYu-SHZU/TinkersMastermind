package net.qiuyu.tinkersmastermind.datagen;


import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.qiuyu.tinkersmastermind.TinkersMastermind;
import net.qiuyu.tinkersmastermind.register.ModBlocks;
import net.qiuyu.tinkersmastermind.register.ModItems;


public class ModLangGenCN extends LanguageProvider {
    public ModLangGenCN(PackOutput output, String locale) {
        super(output, TinkersMastermind.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItems.zombie_iron.get(), "僵尸铁");
        add(ModBlocks.ZOMBIE_IRON_BLOCK.get(), "僵尸铁块");
        add("itemGroup.tinkersmastermind.tab","匠魂长阶");
        add("item.tinkersmastermind.molten_zombie_iron_bucket", "熔融僵尸铁桶");
        add("fluid_type.tinkersmastermind.molten_zombie_iron", "熔融僵尸铁");
    }
}
