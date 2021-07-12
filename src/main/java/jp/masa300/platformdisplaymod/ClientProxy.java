package jp.masa300.platformdisplaymod;

import cpw.mods.fml.client.registry.ClientRegistry;
import jp.masa300.platformdisplaymod.block.tileentity.RenderPlatformDisplay;
import jp.masa300.platformdisplaymod.block.tileentity.TileEntityPlatformDisplay;
import jp.masa300.platformdisplaymod.modelpack.cfg.DisplayConfig;
import jp.masa300.platformdisplaymod.modelpack.modelset.ModelSetDisplayClient;
import jp.ngt.rtm.modelpack.ModelPackManager;

public class ClientProxy extends CommonProxy {
    public void preInit() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlatformDisplay.class, new RenderPlatformDisplay());

        ModelPackManager.INSTANCE.registerType("ModelDisplay", DisplayConfig.class, ModelSetDisplayClient.class);
    }
}
