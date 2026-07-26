package io.github.lordjirix.techlitex.api.wrench;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public interface IWrenchableEntity {
    byte getSide();
    void setSide(byte side);
}
