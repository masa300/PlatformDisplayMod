package jp.masa300.platformdisplaymod.modelpack.cfg;

import jp.ngt.rtm.modelpack.cfg.ModelConfig;

public class DisplayConfig extends ModelConfig {
    public static final String TYPE = "ModelDisplay";

    /**
     * 名前(重複不可)
     */
    private String name;
    /**
     * モデル
     */
    public ModelSource model;

    public String sound_OnActivate;
    public String sound_Running;

    public boolean rotateByMetadata;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getModelType() {
        return TYPE;
    }

    public static DisplayConfig getDummy() {
        DisplayConfig cfg = new DisplayConfig();
        cfg.name = "dummy";
        cfg.init();
        return cfg;
    }
}
