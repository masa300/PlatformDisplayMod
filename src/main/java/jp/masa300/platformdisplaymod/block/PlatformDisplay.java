package jp.masa300.platformdisplaymod.block;

import jp.masa300.platformdisplaymod.block.tileentity.TileEntityPlatformDisplay;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PlatformDisplay extends BlockContainer {

    public PlatformDisplay() {
        super(Material.glass);
        this.setStepSound(soundTypeGlass);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityPlatformDisplay();
    }
}
