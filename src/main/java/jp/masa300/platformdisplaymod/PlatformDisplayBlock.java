package jp.masa300.platformdisplaymod;

import cpw.mods.fml.common.registry.GameRegistry;
import jp.masa300.platformdisplaymod.block.PlatformDisplay;
import net.minecraft.block.Block;

public class PlatformDisplayBlock {
    public static Block blockPlatformDisplay;

    public void preInit() {
        GameRegistry.registerBlock(blockPlatformDisplay = new PlatformDisplay(), "PlatformDisplay");
    }
}
