package net.qiuyu.tinkersmastermind.datagen;


import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.qiuyu.tinkersmastermind.TinkersMastermind;
import net.qiuyu.tinkersmastermind.register.ModBlocks;
import net.qiuyu.tinkersmastermind.register.ModItems;


public class ModLangGenEN extends LanguageProvider {
    public ModLangGenEN(PackOutput output, String locale) {
        super(output, TinkersMastermind.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItems.ZOMBIE_IRON.get(), "Zombie Iron");
        add(ModBlocks.ZOMBIE_IRON_BLOCK.get(), "Zombie Iron Block");
        add("fluid_type.tinkersmastermind.molten_zombie_iron", "Molten Zombie Iron");
        add("item.tinkersmastermind.molten_zombie_iron_bucket", "Molten Zombie Iron Bucket");
        add("itemGroup.tinkersmastermind.tab","Tinkers' Mastermind");
        add("modifier.tinkersmastermind.rotten I","Rotten I");
        add("modifier.tinkersmastermind.rotten II","Rotten II");
        add("modifier.tinkersmastermind.rotten III","Rotten III");
        add("modifier.tinkersmastermind.rotten IV","Rotten IV");
        add("modifier.tinkersmastermind.hungry I","I'm Hungry I");
        add("modifier.tinkersmastermind.hungry II","I'm Hungry II");
        add("modifier.tinkersmastermind.hungry III","I'm Hungry III");
        add("modifier.tinkersmastermind.hungry IV","I'm Hungry IV");
        add("modifier.tinkersmastermind.bluster I","Bluster I");
        add("modifier.tinkersmastermind.bluster II","Bluster II");
        add("modifier.tinkersmastermind.bluster III","Bluster III");
        add("modifier.tinkersmastermind.bluster IV","Bluster IV");
    }

}
