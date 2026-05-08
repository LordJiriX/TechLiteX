package io.github.lordjirix.techlitex.common.data;

import io.github.lordjirix.techlitex.TLXData;
import io.github.lordjirix.techlitex.TechLiteX;
import io.github.lordjirix.techlitex.loader.TLXItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class TLXItemModelGen extends ItemModelProvider {

  public TLXItemModelGen(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
    super(output, modid, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    simpleItem(TLXItems.MULTI_TOOL);
    // Materials ++ Parts
    TLXData.allItemList.forEach(
        item -> {
          simpleItem(item);
        });
  }

  @SuppressWarnings("removal")
  private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
    //noinspection removal
    return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated"))
        .texture(
            "layer0", new ResourceLocation(TechLiteX.MODID, "item/" + item.getId().getPath()));
  }
}
