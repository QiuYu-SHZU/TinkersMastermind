package net.qiuyu.tinkersmastermind.datagen;


import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.qiuyu.tinkersmastermind.TinkersMastermind;
import net.qiuyu.tinkersmastermind.register.TinkersMastermindItems;


public class ModItemModelGen extends ItemModelProvider {

    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";


    public ModItemModelGen(DataGenerator gen, ExistingFileHelper existingFileHelper) {
        super(gen, TinkersMastermind.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        itemGeneratedModel(TinkersMastermindItems.sticky_potion.get(), resourceItem((itemName(TinkersMastermindItems.sticky_potion.get()))));
        itemGeneratedModel(TinkersMastermindItems.poison_coating_lvl1.get(), resourceItem((itemName(TinkersMastermindItems.poison_coating_lvl1.get()))));
        itemGeneratedModel(TinkersMastermindItems.poison_coating_lvl2.get(), resourceItem((itemName(TinkersMastermindItems.poison_coating_lvl2.get()))));
        itemGeneratedModel(TinkersMastermindItems.poison_coating_lvl3.get(), resourceItem((itemName(TinkersMastermindItems.poison_coating_lvl3.get()))));

    }

    public void itemGeneratedModel(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
    }

    private String itemName(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(TinkersMastermind.MOD_ID, "block/" + path);
    }

    public ResourceLocation resourceItem(String path) {
        return new ResourceLocation(TinkersMastermind.MOD_ID, "item/" + path);
    }
}
