package com.example.steeringaddon;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;

public class SteeringControllerEntity extends BlockEntity {
    private float currentAngle = 0f;

    public SteeringControllerEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STEERING_CONTROLLER_ENTITY.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, SteeringControllerEntity be) {
        if (level.isClientSide) return;

        int redstone = level.getBestNeighborSignal(pos);
        float targetAngle = ((redstone - 7.5f) / 7.5f) * 30f;
        be.currentAngle += (targetAngle - be.currentAngle) * 0.25f;

        be.applyAngleToBearings(be.currentAngle);
    }

    private void applyAngleToBearings(float angle) {
        if (level == null) return;
        for (int dx = -2; dx <= 2; dx++) {
            for (int dz = -2; dz <= 2; dz++) {
                BlockPos mpos = worldPosition.offset(dx, 0, dz);
                BlockEntity be = level.getBlockEntity(mpos);
                if (be == null) continue;
                try {
                    Class<?> kineticClass = Class.forName("com.simibubi.create.content.kinetics.base.KineticBlockEntity");
                    if (kineticClass.isInstance(be)) {
                        try {
                            kineticClass.getMethod("setAngle", float.class).invoke(be, angle);
                        } catch (NoSuchMethodException ignored) {}
                    }
                } catch (Exception ignored) {}
            }
        }
    }

    public void markDirtyClient() {
        setChanged();
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        currentAngle = tag.getFloat("currentAngle");
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        tag.putFloat("currentAngle", currentAngle);
    }
}
