package jp.masa300.platformdisplaymod;

import jp.masa300.platformdisplaymod.modelpack.cfg.DisplayConfig;
import jp.masa300.platformdisplaymod.modelpack.modelset.ModelSetDisplayClient;
import jp.ngt.rtm.modelpack.ModelPackManager;

public class ClientProxy extends CommonProxy {
    public void preInit() {
        ModelPackManager.INSTANCE.registerType("ModelDisplay", DisplayConfig.class, ModelSetDisplayClient.class);
    }
}
