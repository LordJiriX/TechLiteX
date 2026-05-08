package io.github.lordjirix.techlitex.common.data;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;

import io.github.lordjirix.techlitex.loader.TLXBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class TLXBlockModelGen extends BlockStateProvider {

  public TLXBlockModelGen(PackOutput output, ExistingFileHelper exFileHelper) {
    super(output, MODID, exFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {
    blockWithItem(TLXBlocks.MACHINE_CASING_STEEL);
    blockWithItem(TLXBlocks.COKE_OVEN_BRICK_BLOCK);
  }

  private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
    simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
  }
}
