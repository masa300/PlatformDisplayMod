package jp.masa300.platformdisplaymod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import jp.masa300.platformdisplaymod.block.tileentity.TileEntityPlatformDisplay;
import jp.masa300.platformdisplaymod.gui.PlatfromDisplayGUIHandler;

@Mod(modid = PlatformDisplayCore.MODID, version = PlatformDisplayCore.VERSION, name = PlatformDisplayCore.MODID)
public class PlatformDisplayCore {
    public static final String MODID = "PlatformDisplayMod";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(MODID)
    public static PlatformDisplayCore INSTANCE;

    public static final int guiId_platformDisplay = 0;

    @SidedProxy(clientSide = "jp.masa300.platformdisplaymod.ClientProxy", serverSide = "jp.masa300.platformdisplaymod.CommonProxy")
    public static CommonProxy proxy;

    public static final SimpleNetworkWrapper NETWORK_WRAPPER = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new PlatfromDisplayGUIHandler());
//        NETWORK_WRAPPER.registerMessage(PacketSignalController.class, PacketSignalController.class, 0, Side.SERVER);
        GameRegistry.registerTileEntity(TileEntityPlatformDisplay.class, "TE_PlatformDisplay");
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        new PlatformDisplayBlock().preInit();
        new PlatformDisplayItem().preInit();
        proxy.preInit();
    }
}
