package jp.masa300.platformdisplaymod.block.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jp.masa300.platformdisplaymod.modelpack.cfg.DisplayConfig;
import jp.masa300.platformdisplaymod.modelpack.modelset.ModelSetDisplayClient;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class RenderPlatformDisplay extends TileEntitySpecialRenderer {

    public void renderPlatformDisplayAt(TileEntityPlatformDisplay tileEntity, double par2, double par4, double par6, float par8) {
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef((float)par2 + 0.5F, (float)par4, (float)par6 + 0.5F);

        ModelSetDisplayClient modelSet = (ModelSetDisplayClient)tileEntity.getModelSet();
        DisplayConfig cfg = modelSet.getConfig();
        GL11.glTranslatef(0.0F, 0.5F, 0.0F);
        if(cfg.rotateByMetadata) {
            switch(tileEntity.getBlockMetadata()) {
                case 0: GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);break;//-y
                case 1: break;
                case 2: GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);break;//-z
                case 3: GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);break;//+z
                case 4: GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);break;//+x
                case 5: GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);break;//-x
            }
        }
        GL11.glTranslatef(0.0F, -0.5F, 0.0F);
        float yaw = tileEntity.getRotation();
        if(cfg.rotateByMetadata && tileEntity.getBlockMetadata() == 0) {
            yaw = -yaw;
        }
        GL11.glRotatef(yaw, 0.0F, 1.0F, 0.0F);
        int pass = MinecraftForgeClient.getRenderPass();
        modelSet.modelObj.render(tileEntity, cfg, pass, par8);
        GL11.glPopMatrix();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double par2, double par4, double par6, float par8) {
        this.renderPlatformDisplayAt((TileEntityPlatformDisplay)tileEntity, par2, par4, par6, par8);
    }
}
