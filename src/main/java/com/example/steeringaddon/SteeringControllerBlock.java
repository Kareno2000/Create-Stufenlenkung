package com.example.steeringaddon;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;

public class SteeringControllerBlock extends Block implements EntityBlock {
    public SteeringControllerBlock() {
        super(Properties.of(net.minecraft.world.level.material.Material.METAL).strength(2.0f));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SteeringControllerEntity(pos, state);
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, world, pos, block, fromPos, isMoving);
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof SteeringControllerEntity sce) {
            sce.markDirtyClient();
        }
    }
}
