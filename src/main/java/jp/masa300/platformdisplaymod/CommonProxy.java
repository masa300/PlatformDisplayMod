package jp.masa300.platformdisplaymod;

import jp.masa300.platformdisplaymod.modelpack.cfg.DisplayConfig;
import jp.masa300.platformdisplaymod.modelpack.modelset.ModelSetDisplay;
import jp.ngt.rtm.modelpack.ModelPackManager;

public class CommonProxy {
    public void preInit() {
        ModelPackManager.INSTANCE.registerType("ModelDisplay",	DisplayConfig.class, ModelSetDisplay.class);
    }
}
