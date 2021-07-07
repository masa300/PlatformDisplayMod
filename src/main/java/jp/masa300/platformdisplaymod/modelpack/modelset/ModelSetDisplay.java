package jp.masa300.platformdisplaymod.modelpack.modelset;

import jp.masa300.platformdisplaymod.modelpack.cfg.DisplayConfig;
import jp.ngt.rtm.modelpack.modelset.ModelSetBase;
import net.minecraft.util.ResourceLocation;

public class ModelSetDisplay extends ModelSetBase<DisplayConfig> {
    public final ResourceLocation sound_OnActivate;
    public final ResourceLocation sound_Running;

    public ModelSetDisplay () {
        super();
        this.sound_OnActivate = null;
        this.sound_Running = null;
    }

    public ModelSetDisplay (DisplayConfig par1) {
        super(par1);
        this.sound_OnActivate = this.getSoundResource(par1.sound_OnActivate);
        this.sound_Running = this.getSoundResource(par1.sound_Running);
    }

    @Override
    public DisplayConfig getDummyConfig() {
        return DisplayConfig .getDummy();
    }
}
