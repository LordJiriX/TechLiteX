package io.github.lordjirix.techlitex.compact.jade;

import io.github.lordjirix.techlitex.common.block.*;
import io.github.lordjirix.techlitex.common.entity.*;
import io.github.lordjirix.techlitex.compact.jade.provider.BedrockMinerComponentProvider;
import io.github.lordjirix.techlitex.compact.jade.provider.CokeOvenComponentProvider;
import io.github.lordjirix.techlitex.compact.jade.provider.RecipeRunnableProvider;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class TLXJadePlugin implements IWailaPlugin {
  @Override
  public void register(IWailaCommonRegistration registration) {
    registration.registerBlockDataProvider(
        BedrockMinerComponentProvider.INSTANCE, BedrockMinerBlockEntity.class);
    registration.registerBlockDataProvider(
        RecipeRunnableProvider.INSTANCE, GreenHouseBlockEntity.class);
    registration.registerBlockDataProvider(
        RecipeRunnableProvider.INSTANCE, TimeCompressorBlockEntity.class);
    registration.registerBlockDataProvider(
        RecipeRunnableProvider.INSTANCE, GrinderBlockEntity.class);
    registration.registerBlockDataProvider(
        CokeOvenComponentProvider.INSTANCE, CokeOvenBlockEntity.class);
    registration.registerBlockDataProvider(
        RecipeRunnableProvider.INSTANCE, SeparatorBlockEntity.class);
    // TODO register data providers
  }

  @Override
  public void registerClient(IWailaClientRegistration registration) {
    registration.registerBlockComponent(
        BedrockMinerComponentProvider.INSTANCE, BlockBedrockMiner.class);
    registration.registerBlockComponent(RecipeRunnableProvider.INSTANCE, BlockGreenHouse.class);
    registration.registerBlockComponent(RecipeRunnableProvider.INSTANCE, TimeCompressorBlock.class);
    registration.registerBlockComponent(RecipeRunnableProvider.INSTANCE, GrinderBlock.class);
    registration.registerBlockComponent(CokeOvenComponentProvider.INSTANCE, CokeOvenBlock.class);
    registration.registerBlockComponent(RecipeRunnableProvider.INSTANCE, SeparatorBlock.class);
    // TODO register component providers, icon providers, callbacks, and config options here
  }
}
