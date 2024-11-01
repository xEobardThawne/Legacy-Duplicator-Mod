package xreversef1ash.legacyduplicatormod.screens;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import xreversef1ash.legacyduplicatormod.LegacyDuplicatorMod;
import xreversef1ash.legacyduplicatormod.items.DuplicatorItemRegistry;

import java.util.List;

public class InfDupStickPartMakerHandledScreen extends HandledScreen<InfDupStickPartMakerScreenHandler> {
    private final Identifier TEXTURE = Identifier.of(LegacyDuplicatorMod.MOD_ID, "textures/gui/container/infinidup_stick_part_maker.png");

    public InfDupStickPartMakerHandledScreen(InfDupStickPartMakerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        if (this.getScreenHandler().getSlot(0).getStack().isEmpty()) {
            drawInfo(context, 0, x + 16, y + 42, mouseX, mouseY, new ItemStack(DuplicatorItemRegistry.UNDUPLICATABLE_ITEM_ONE, 10));
        }
        if (this.getScreenHandler().getSlot(1).getStack().isEmpty()) {
            drawInfo(context, 1, x + 52, y + 42, mouseX, mouseY, new ItemStack(DuplicatorItemRegistry.UNDUPLICATABLE_ITEM_TWO, 4));
        }
        if (this.getScreenHandler().getSlot(2).getStack().isEmpty()) {
            drawInfo(context, 2, x + 88, y + 42, mouseX, mouseY, new ItemStack(Items.STICKY_PISTON, 5));
        }
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }

    private void drawInfo(DrawContext context, int slot, int x, int y, int mouseX, int mouseY, ItemStack costStack) {
        if (this.getScreenHandler().getSlot(slot) == this.focusedSlot) {
            context.drawItem(costStack, x + 1, y + 1);
            context.drawTooltip(this.textRenderer, List.of(
                            Text.literal("Cost:").withColor(ColorHelper.Argb.getArgb(0, 255, 255)),
                            Text.literal("Item: ").append(Text.translatable(costStack.getTranslationKey())).withColor(Colors.LIGHT_GRAY),
                            Text.literal("Count: ").append(Text.literal(String.valueOf(costStack.getCount()))).withColor(Colors.LIGHT_GRAY)
                    ),
                    mouseX, mouseY);
        } else {
            context.drawTexture(Identifier.of(LegacyDuplicatorMod.MOD_ID, "textures/gui/container/infoicon.png"), x, y, 0, 0, 18, 18, 18, 18);
        }
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int x = (this.width - this.backgroundWidth) / 2;
        int y = (this.height - this.backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }
}
