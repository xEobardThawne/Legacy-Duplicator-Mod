package xreversef1ash.legacyduplicatormod.screens;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xreversef1ash.legacyduplicatormod.LegacyDuplicatorMod;

public class ItemDuplicatorHandledScreen extends HandledScreen<ItemDuplicatorScreenHandler> {
    private final Identifier TEXTURE = Identifier.of(LegacyDuplicatorMod.MOD_ID, "textures/gui/container/item_duplicator.png");

    public ItemDuplicatorHandledScreen(ItemDuplicatorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        ButtonWidget duplicateButton = ButtonWidget.builder(
                        Text.translatable("container.button.duplicatetext"),
                        button -> {
                            if (this.client != null) {
                                if (this.handler.onButtonClick(this.client.player, 1)) {
                                    this.client.interactionManager.clickButton(this.handler.syncId, 1);
                                }
                            }
                        }
                )
                .dimensions(x + 63, y + 28, 49, 18)
                .build();
        this.addDrawableChild(duplicateButton);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }


    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int x = (this.width - this.backgroundWidth) / 2;
        int y = (this.height - this.backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }
}
