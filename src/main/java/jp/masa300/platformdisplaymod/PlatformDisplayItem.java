package jp.masa300.platformdisplaymod;

import cpw.mods.fml.common.registry.GameRegistry;
import jp.masa300.platformdisplaymod.item.ItemPlatformDisplay;
import net.minecraft.item.Item;

public class PlatformDisplayItem {
    public static Item itemPlatformDisplay;

    public void preInit() {
        GameRegistry.registerItem(itemPlatformDisplay = new ItemPlatformDisplay(), "ItemPlatformDisplay");
    }
}
