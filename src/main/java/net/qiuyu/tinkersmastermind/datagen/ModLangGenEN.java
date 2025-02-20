package net.qiuyu.tinkersmastermind.datagen;


import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.qiuyu.tinkersmastermind.TinkersMastermind;
import net.qiuyu.tinkersmastermind.register.TinkersMastermindItems;


public class ModLangGenEN extends LanguageProvider {
    public ModLangGenEN(PackOutput output, String locale) {
        super(output, TinkersMastermind.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(TinkersMastermindItems.zombie_iron.get(), "Zombie Iron");
        add("itemGroup.tinkersmastermind.tab","Tinkers' Mastermind");
    }

}
