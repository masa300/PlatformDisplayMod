package jp.masa300.platformdisplaymod.gui;

import jp.masa300.platformdisplaymod.block.tileentity.TileEntityPlatformDisplay;
import jp.masa300.platformdisplaymod.gui.parts.GuiScreenCustom;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;

public class GUIPlatformDisplay extends GuiScreenCustom {
    private final TileEntityPlatformDisplay tile;

    public GUIPlatformDisplay(TileEntityPlatformDisplay tile) {
        this.tile = tile;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTick) {
        super.drawScreen(mouseX, mouseY, partialTick);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        super.actionPerformed(button);
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void keyTyped(char par1, int par2) {
        super.keyTyped(par1, par2);

        if(par2 == Keyboard.KEY_RETURN) {
            this.mc.displayGuiScreen(null);
        }
    }

    private int getIntGuiTextFieldText(int number) {
        String str = this.textFieldList.get(number).getText();
        int i = 0;
        if (str == null || str.isEmpty()) {
            return i;
        }

        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return i;
        }
        return i;
    }

    private void addGuiTextField(String str, int xPosition, int yPosition, int maxLength, int width) {
        GuiTextField text = new GuiTextField(this.fontRendererObj, xPosition, yPosition, width, 20);
        text.setFocused(false);
        text.setMaxStringLength(maxLength);
        text.setText(str);
        this.textFieldList.add(text);
    }
}
