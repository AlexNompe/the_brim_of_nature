package net.thebrimofnature.block.entity.screenhandler;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.thebrimofnature.The_Brim_Of_Nature;
import net.thebrimofnature.block.entity.Alloyery_Enchanter_BlockEntity;
import net.thebrimofnature.registry.TheBrimOfNatureScreenHandlerRegistry;

public class Alloyery_Enchanter_ScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    public final Alloyery_Enchanter_BlockEntity blockEntity;

    public Alloyery_Enchanter_ScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()));
    }

    public Alloyery_Enchanter_ScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity) {
        super(TheBrimOfNatureScreenHandlerRegistry.ALLOYERY_ENCHANTER_SCREENHANDLER, syncId);
        checkSize(((Inventory) blockEntity), 8);
        this.inventory = ((Inventory) blockEntity);
        inventory.onOpen(playerInventory.player);
        this.blockEntity = ((Alloyery_Enchanter_BlockEntity) blockEntity);

        this.addSlot(new Slot(inventory, 0, 31, 35));
        this.addSlot(new Slot(inventory, 1, 87, 23));
        this.addSlot(new Slot(inventory, 2, 108, 15));
        this.addSlot(new Slot(inventory, 3, 129, 23));
        this.addSlot(new Slot(inventory, 4, 87, 46));
        this.addSlot(new Slot(inventory, 5, 108, 54));
        this.addSlot(new Slot(inventory, 6, 129, 46));

        int m;
        int l;
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }

    }
    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
}
