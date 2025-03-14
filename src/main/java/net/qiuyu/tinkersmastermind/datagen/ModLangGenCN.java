package net.qiuyu.tinkersmastermind.datagen;


import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.qiuyu.tinkersmastermind.TinkersMastermind;
import net.qiuyu.tinkersmastermind.register.ModBlocks;
import net.qiuyu.tinkersmastermind.register.ModEffects;
import net.qiuyu.tinkersmastermind.register.ModItems;


public class ModLangGenCN extends LanguageProvider {
    public ModLangGenCN(PackOutput output, String locale) {
        super(output, TinkersMastermind.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItems.ZOMBIE_IRON.get(), "僵尸铁");
        add(ModBlocks.ZOMBIE_IRON_BLOCK.get(), "僵尸铁块");
        add(ModBlocks.JIMSONWEED_BLOCK.get(), "曼陀罗合金块");
        add(ModItems.JIMSONWEED.get(), "曼陀罗合金");
        add(ModItems.VOMIT.get(), "呕吐物");
        add(ModItems.INSOLE.get(), "鞋垫");
        add(ModEffects.POISON_RESIST.get(),"猛毒耐性");
        add(ModEffects.FOOT_CLEAN.get(),"干净的脚");
        add(ModEffects.FOOT_ODOR.get(),"脚臭");
        add("modifier.tinkersmastermind.insole.description","记得洗脚.");
        add("itemGroup.tinkersmastermind.tab","匠魂长阶");
        add("item.tinkersmastermind.molten_zombie_iron_bucket", "熔融僵尸铁桶");
        add("fluid_type.tinkersmastermind.molten_zombie_iron", "熔融僵尸铁");
        add("fluid_type.tinkersmastermind.molten_jimsonweed", "熔融曼陀罗合金");
        add("item.tinkersmastermind.molten_jimsonweed_bucket", "熔融曼陀罗合金桶");
        add("modifier.tinkersmastermind.rotten","霉味");
        add("modifier.tinkersmastermind.hungry","我饿了");
        add("modifier.tinkersmastermind.hungry.description","114514");
        add("modifier.tinkersmastermind.bluster","爆燃");
        add("modifier.tinkersmastermind.poison_sparkle","毒性荆棘");
        add("modifier.tinkersmastermind.poison_erosion","毒性腐蚀");
        add("modifier.tinkersmastermind.heavy_poison","猛毒");
    }
}
