package net.thebrimofnature.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ai.brain.MemoryQuery;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thebrimofnature.The_Brim_Of_Nature;
import net.thebrimofnature.inventory.Inplemented_Inventory;
import net.thebrimofnature.recipe.Alloyery_Enchanter_Recipery;
import net.thebrimofnature.registry.TheBrimOfNatureBlockEntityRegistry;
import net.thebrimofnature.block.entity.screenhandler.Alloyery_Enchanter_ScreenHandler;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class Alloyery_Enchanter_BlockEntity extends BlockEntity implements GeoBlockEntity, Inplemented_Inventory, ExtendedScreenHandlerFactory {

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT1 = 1;
    private static final int OUTPUT_SLOT2 = 2;
    private static final int OUTPUT_SLOT3 = 3;
    private static final int OUTPUT_SLOT4 = 4;
    private static final int OUTPUT_SLOT5 = 5;
    private static final int OUTPUT_SLOT6 = 6;

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(8, ItemStack.EMPTY);
    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.alloyery_enchanter.idle");
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    public Alloyery_Enchanter_BlockEntity(BlockPos pos, BlockState state) {
        super(TheBrimOfNatureBlockEntityRegistry.ALLOYERY_ENCHANTER_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, state -> {
            return state.setAndContinue(IDLE);
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new Alloyery_Enchanter_ScreenHandler(syncId, playerInventory, this);
    }

    private Optional<Alloyery_Enchanter_Recipery> getCurrentRecipe() {
        SimpleInventory inv = new SimpleInventory(this.size());
        for(int i = 0; i < this.size(); i++) {
            inv.setStack(i, this.getStack(i));
        }

        return getWorld().getRecipeManager().getFirstMatch(Alloyery_Enchanter_Recipery.Type.INSTANCE, inv, getWorld());
    }

    private void craftItem() {
        Optional<Alloyery_Enchanter_Recipery> recipe = getCurrentRecipe();

        this.removeStack(INPUT_SLOT, 1);
        this.removeStack(OUTPUT_SLOT1, 1);
        this.removeStack(OUTPUT_SLOT2, 1);
        this.removeStack(OUTPUT_SLOT3, 1);
        this.removeStack(OUTPUT_SLOT4, 1);
        this.removeStack(OUTPUT_SLOT5, 1);
        this.removeStack(OUTPUT_SLOT6, 1);

        this.setStack(OUTPUT_SLOT1, new ItemStack(recipe.get().getOutput(null).getItem(),
                getStack(OUTPUT_SLOT1).getCount() + recipe.get().getOutput(null).getCount()));
    }

    private boolean hasRecipe() {
        Optional<Alloyery_Enchanter_Recipery> recipe = getCurrentRecipe();

        return recipe.isPresent();
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()) {
            return;
        }

        if(this.hasRecipe()) {
            markDirty(world, pos, state);

            this.craftItem();
        }
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.items);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }
}
