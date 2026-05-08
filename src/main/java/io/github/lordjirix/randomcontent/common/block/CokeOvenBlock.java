package io.github.lordjirix.randomcontent.common.block;

import io.github.lordjirix.randomcontent.common.entity.CokeOvenBlockEntity;
import io.github.lordjirix.randomcontent.common.entity.TimeCompressorBlockEntity;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CokeOvenBlock extends Block implements EntityBlock {
  public CokeOvenBlock(Properties properties) {
    super(properties);
  }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CokeOvenBlockEntity(pPos, pState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return pLevel.isClientSide
                ? null
                : (lvl, pos, st, be) -> {
            if (be instanceof CokeOvenBlockEntity te) {
                te.tick();
            }
        };
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {return InteractionResult.SUCCESS;}
        BlockEntity te = pLevel.getBlockEntity(pPos);
        if (te instanceof CokeOvenBlockEntity be) {
            if (!be.isValid()) {
                pPlayer.displayClientMessage(Component.literal("Invalid Structure!"), true);
                return InteractionResult.CONSUME;
            }
        }
        if (te instanceof MenuProvider provider) {
            NetworkHooks.openScreen((ServerPlayer) pPlayer, provider, pPos);
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
        if (Screen.hasShiftDown()) {
            pTooltip.add(Component.literal(" B "));
            pTooltip.add(Component.literal("BFB"));
            pTooltip.add(Component.literal(" B "));
            pTooltip.add(Component.literal(" - "));
            pTooltip.add(Component.literal(" C "));
            pTooltip.add(Component.literal(" - "));
            pTooltip.add(Component.literal(" B "));
            pTooltip.add(Component.literal(" - "));
            pTooltip.add(Component.literal(" C = Coke Oven Block "));
            pTooltip.add(Component.literal(" F = Coke Oven Firebox "));
            pTooltip.add(Component.literal(" B = Coke Oven Bricks Block"));
            return;
        }
        if (Screen.hasControlDown()) {
            pTooltip.add(Component.literal("Require: "));
            pTooltip.add(Component.literal("- Coke Oven Block 1x "));
            pTooltip.add(Component.literal("- Coke Oven Firebox 1x "));
            pTooltip.add(Component.literal("- Coke Oven Bricks Block 5x "));
            return;
        }
        pTooltip.add(Component.literal("Cokee Time!"));
        pTooltip.add(Component.literal("Multiblock"));
        pTooltip.add(Component.literal("[SHIFT] - [CTRL]"));
    }
}
