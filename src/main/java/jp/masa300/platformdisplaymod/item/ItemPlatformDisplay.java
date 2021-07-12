package jp.masa300.platformdisplaymod.item;

import jp.masa300.platformdisplaymod.PlatformDisplayBlock;
import jp.masa300.platformdisplaymod.PlatformDisplayCore;
import jp.masa300.platformdisplaymod.block.tileentity.TileEntityPlatformDisplay;
import jp.masa300.platformdisplaymod.modelpack.cfg.DisplayConfig;
import jp.ngt.rtm.CreativeTabRTM;
import jp.ngt.rtm.item.ItemWithModel;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPlatformDisplay extends ItemWithModel {

    public ItemPlatformDisplay() {
        super();
        this.setTextureName(PlatformDisplayCore.MODID.toLowerCase() + ":" + "ItemPlatformDisplay");
        this.setUnlocalizedName(PlatformDisplayCore.MODID + ":" + "ItemPlatformDisplay");
        this.setCreativeTab(CreativeTabRTM.tabRailway);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (side == 0) {//up
                --y;
            } else if (side == 1) {//down
                ++y;
            } else if (side == 2) {//south
                --z;
            } else if (side == 3) {//north
                ++z;
            } else if (side == 4) {//east
                --x;
            } else if (side == 5) {//west
                ++x;
            }

            if (!world.isAirBlock(x, y, z)) return true;

            world.setBlock(x, y, z, PlatformDisplayBlock.blockPlatformDisplay, 0, 3);
            TileEntityPlatformDisplay tile = (TileEntityPlatformDisplay) world.getTileEntity(x, y, z);
            tile.setRotation(player, 15.0F, true);
            tile.setModelName(this.getModelName(itemStack));

            Block block = PlatformDisplayBlock.blockPlatformDisplay;
            world.playSoundEffect((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D,
                    block.stepSound.func_150496_b(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
            --itemStack.stackSize;
        }
        return true;
    }

    @Override
    protected String getModelType(ItemStack itemStack) {
        return DisplayConfig.TYPE;
    }

    @Override
    protected String getDefaultModelName(ItemStack itemStack) {
        return "PlatformDisplay01";
    }
}
