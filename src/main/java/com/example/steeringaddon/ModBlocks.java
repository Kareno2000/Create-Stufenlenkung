package com.example.steeringaddon;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SteeringAddon.MODID);

    public static final RegistryObject<Block> STEERING_CONTROLLER =
            BLOCKS.register("steering_controller", SteeringControllerBlock::new);

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
