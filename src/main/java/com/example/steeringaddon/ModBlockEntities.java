package com.example.steeringaddon;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SteeringAddon.MODID);

    public static final RegistryObject<BlockEntityType<SteeringControllerEntity>> STEERING_CONTROLLER_ENTITY =
            BLOCK_ENTITIES.register("steering_controller_entity",
                () -> BlockEntityType.Builder.of(SteeringControllerEntity::new, ModBlocks.STEERING_CONTROLLER.get()).build(null));

    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }
}
