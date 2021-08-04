package jp.masa300.platformdisplaymod.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import jp.masa300.platformdisplaymod.PlatformDisplayCore;
import jp.masa300.platformdisplaymod.block.tileentity.TileEntityPlatformDisplay;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class PlatfromDisplayGUIHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == PlatformDisplayCore.guiId_platformDisplay) {
            return new GUIPlatformDisplay((TileEntityPlatformDisplay) player.worldObj.getTileEntity(x, y, z));
        }
        return null;
    }
}
