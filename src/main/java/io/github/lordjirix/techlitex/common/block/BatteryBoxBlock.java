package io.github.lordjirix.techlitex.common.block;

import io.github.lordjirix.techlitex.api.block.BaseBlock;
import io.github.lordjirix.techlitex.api.wrench.IWrenchMinable;
import io.github.lordjirix.techlitex.common.entity.BatteryBoxEntity;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BatteryBoxBlock extends Block implements EntityBlock {

  public BatteryBoxBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new BatteryBoxEntity(pPos, pState);
  }
  @Override
  public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(
      Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
    return pLevel.isClientSide
        ? null
        : (lvl, pos, st, be) -> {
          if (be instanceof BatteryBoxEntity te) {
            te.tick();
          }
        };
  }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
        if (Screen.hasShiftDown()) {
            pTooltip.add(Component.literal("Lose all energy when break"));
            pTooltip.add(Component.literal("Output Energy only from output side"));
        }
        pTooltip.add(Component.literal("Energy Box!!!"));
        pTooltip.add(Component.literal("Store Energy"));
  }
}
