package jp.masa300.platformdisplaymod;

import cpw.mods.fml.common.registry.GameRegistry;
import jp.masa300.platformdisplaymod.block.PlatformDisplay;
import jp.ngt.ngtlib.util.NGTUtil;
import net.minecraft.block.Block;

public class PlatformDisplayBlock {
    public static Block blockPlatformDisplay;

    public static int renderIdPlatformDisplay;

    public void preInit() {
        GameRegistry.registerBlock(blockPlatformDisplay = new PlatformDisplay(), "PlatformDisplay");

        renderIdPlatformDisplay = (short) NGTUtil.getNewRenderType();
    }
}
