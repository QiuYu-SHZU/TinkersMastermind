package net.qiuyu.tinkersmastermind.datagen;


import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import net.qiuyu.tinkersmastermind.TinkersMastermind;
import net.qiuyu.tinkersmastermind.register.TinkersMastermindItems;


public class ModLangGenEN extends LanguageProvider {
    public ModLangGenEN(DataGenerator gen, String locale) {
        super(gen, TinkersMastermind.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(TinkersMastermindItems.poison_coating_lvl1.get(), "Poison Coating I");

    }

}
