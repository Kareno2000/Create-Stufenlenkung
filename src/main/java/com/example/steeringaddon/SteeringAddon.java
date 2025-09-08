package com.example.steeringaddon;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(SteeringAddon.MODID)
public class SteeringAddon {
    public static final String MODID = "steeringaddon";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SteeringAddon() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.register(bus);
        ModBlockEntities.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Steering Addon for Create 0.5.1j loaded!");
    }
}
