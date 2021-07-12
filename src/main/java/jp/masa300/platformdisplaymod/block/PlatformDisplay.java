package jp.masa300.platformdisplaymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jp.masa300.platformdisplaymod.PlatformDisplayBlock;
import jp.masa300.platformdisplaymod.PlatformDisplayItem;
import jp.masa300.platformdisplaymod.block.tileentity.TileEntityPlatformDisplay;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class PlatformDisplay extends BlockContainer {

    public PlatformDisplay() {
        super(Material.glass);
        this.setStepSound(soundTypeGlass);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        return true;
    }

    @Override
    public int getRenderType() {
        return PlatformDisplayBlock.renderIdPlatformDisplay;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityPlatformDisplay();
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
        ItemStack itemStack = new ItemStack(PlatformDisplayItem.itemPlatformDisplay, 1, 0);
        return itemStack;

//        TileEntity tileEntity = world.getTileEntity(x, y, z);
//        if (tileEntity instanceof TileEntityPlatformDisplay) {
//            ((ItemPlatformDisplay) PlatformDisplayItem.itemPlatformDisplay).setModelName(itemStack, ((TileEntityPlatformDisplay) tileEntity).getModelName());
//            ((ItemPlatformDisplay) PlatformDisplayItem.itemPlatformDisplay).setModelState(itemStack, ((TileEntityPlatformDisplay) tileEntity).getResourceState());
//            return itemStack;
//        }
//        return null;
    }
}
