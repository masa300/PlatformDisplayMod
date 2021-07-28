package jp.masa300.platformdisplaymod.block.tileentity;

import jp.masa300.platformdisplaymod.modelpack.modelset.ModelSetDisplay;
import jp.ngt.ngtlib.block.TileEntityPlaceable;
import jp.ngt.ngtlib.util.NGTUtil;
import jp.ngt.rtm.modelpack.IModelSelector;
import jp.ngt.rtm.modelpack.ModelPackManager;
import jp.ngt.rtm.modelpack.ScriptExecuter;
import jp.ngt.rtm.modelpack.state.ResourceState;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;

public class TileEntityPlatformDisplay extends TileEntityPlaceable implements IModelSelector {
    private ResourceState state = new ResourceState(this);
    private String modelName = "";
    private Block renderBlock;
    private ScriptExecuter executer = new ScriptExecuter();

    private ModelSetDisplay myModelSet;
    public int tick;
    public float pitch;
    protected Vec3 normal;

    /**メタで保存してた方向データを更新したか*/
    private boolean yawFixed;

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        String s = nbt.getString("ModelName");
        if(s == null || s.length() == 0) {
            s = this.getDefaultName();
        }
        this.setModelName(s);
        this.pitch = nbt.getFloat("Pitch");

        this.yawFixed = nbt.hasKey("Yaw");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setString("modelName", this.modelName);
        nbt.setFloat("Pitch", this.pitch);
    }

    private void sendPacket() {
        NGTUtil.sendPacketToClient(this);
    }

    @Override
    public Packet getDescriptionPacket() {
        this.sendPacket();
        return null;
    }

    @Override
    public ResourceState getResourceState() {
        return this.state;
    }

    @Override
    public String getModelType() {
        return "ModelDisplay";
    }

    @Override
    public String getModelName() {
        return this.modelName;
    }

    @Override
    public void setModelName(String par1) {
        this.modelName = par1;
        this.myModelSet = null;
        if (this.worldObj == null || !this.worldObj.isRemote) {
            this.markDirty();
            this.sendPacket();
        }
    }

    @Override
    public void setRotation(EntityPlayer player, float rotationInterval, boolean synch) {
        super.setRotation(player, rotationInterval, synch);
        this.pitch = -player.rotationPitch;
    }

    @Override
    public void setRotation(float par1, boolean synch)
    {
        super.setRotation(par1, synch);
        this.yawFixed = true;
    }

    public float getPitch() {
        return this.pitch;
    }

    @Override
    public int[] getPos() {
        return new int[]{this.xCoord, this.yCoord, this.zCoord};
    }

    @Override
    public boolean closeGui(String par1) {
        return true;
    }

    @Override
    public ModelSetDisplay getModelSet() {
        if (this.myModelSet == null || this.myModelSet.isDummy()) {
            this.myModelSet = ModelPackManager.INSTANCE.getModelSet("ModelDisplay", this.modelName);
        }
        return this.myModelSet;
    }

    public Vec3 getNormal(float x, float y, float z, float pitch, float yaw) {
        if(this.normal == null) {
            this.normal = Vec3.createVectorHelper(x, y, z);
//            MachinePartsRenderer.rotateVec(this.normal,
//                    this.getBlockMetadata(), pitch, yaw);
        }
        return this.normal;
    }

    /**NBTにモデル名が含まれない場合に使用*/
    protected String getDefaultName() {
        return "PlatformDisplay01";
    }
}
