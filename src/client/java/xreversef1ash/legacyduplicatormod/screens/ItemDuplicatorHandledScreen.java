package xreversef1ash.legacyduplicatormod.screens;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemDuplicatorHandledScreen extends HandledScreen<ScreenHandler> {
    private final Identifier TEXTURE = Identifier.of("minecraft", "textures/gui/container/dispenser.png");

    public ItemDuplicatorHandledScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }


    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {

    }
}
