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
        add(ModItems.ZOMBIE_IRON.get(), "僵尸铁");
        add(ModBlocks.ZOMBIE_IRON_BLOCK.get(), "僵尸铁块");
        add("itemGroup.tinkersmastermind.tab","匠魂长阶");
        add("item.tinkersmastermind.molten_zombie_iron_bucket", "熔融僵尸铁桶");
        add("fluid_type.tinkersmastermind.molten_zombie_iron", "熔融僵尸铁");
        add("modifier.tinkersmastermind.rotten I","霉味 I");
        add("modifier.tinkersmastermind.rotten II","霉味 II");
        add("modifier.tinkersmastermind.rotten III","霉味 III");
        add("modifier.tinkersmastermind.rotten IV","霉味 IV");
        add("modifier.tinkersmastermind.hungry I","我饿了 I");
        add("modifier.tinkersmastermind.hungry II","我饿了 II");
        add("modifier.tinkersmastermind.hungry III","我饿了 III");
        add("modifier.tinkersmastermind.hungry IV","我饿了 IV");
    }
}
