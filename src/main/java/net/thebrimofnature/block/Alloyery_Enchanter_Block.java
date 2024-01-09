package net.thebrimofnature.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.thebrimofnature.block.entity.Alloyery_Enchanter_BlockEntity;
import net.thebrimofnature.registry.TheBrimOfNatureBlockEntityRegistry;
import org.jetbrains.annotations.Nullable;

public class Alloyery_Enchanter_Block extends BlockWithEntity implements BlockEntityProvider {

    public Alloyery_Enchanter_Block(Settings settings) {
        super(settings.nonOpaque());
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView blockView, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(0, 0, 0, 16, 12, 16);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new Alloyery_Enchanter_BlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult) {
        if (world.isClient) return ActionResult.SUCCESS;

        Inventory blockEntity = (Inventory) world.getBlockEntity(blockPos);

        if (!player.getStackInHand(hand).isEmpty()) {
            if (blockEntity.getStack(0).isEmpty()) {
                blockEntity.setStack(0, player.getStackInHand(hand).copyWithCount(1));
                player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
                if (!world.isClient) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_BLOCK_HIT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
            else if (blockEntity.getStack(1).isEmpty()) {
                blockEntity.setStack(1, player.getStackInHand(hand).copyWithCount(1));
                player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
                if (!world.isClient) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_BLOCK_HIT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
            else if (blockEntity.getStack(2).isEmpty()) {
                blockEntity.setStack(2, player.getStackInHand(hand).copyWithCount(1));
                player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
                if (!world.isClient) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_BLOCK_HIT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
            else if (blockEntity.getStack(3).isEmpty()) {
                blockEntity.setStack(3, player.getStackInHand(hand).copyWithCount(1));
                player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
                if (!world.isClient) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_BLOCK_HIT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
            else if (blockEntity.getStack(4).isEmpty()) {
                blockEntity.setStack(4, player.getStackInHand(hand).copyWithCount(1));
                player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
                if (!world.isClient) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_BLOCK_HIT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
            else if (blockEntity.getStack(5).isEmpty()) {
                blockEntity.setStack(5, player.getStackInHand(hand).copyWithCount(1));
                player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
                if (!world.isClient) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_BLOCK_HIT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
            else if (blockEntity.getStack(6).isEmpty()) {
                blockEntity.setStack(6, player.getStackInHand(hand).copyWithCount(1));
                player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
                if (!world.isClient) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_BLOCK_HIT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
        }
        else {
            if (!blockEntity.getStack(7).isEmpty()) {
                player.getInventory().offerOrDrop(blockEntity.getStack(7));
                blockEntity.removeStack(7);
                if (!world.isClient) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_CLUSTER_HIT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
            else if (!blockEntity.getStack(6).isEmpty()) {
                player.getInventory().offerOrDrop(blockEntity.getStack(6));
                blockEntity.removeStack(6);
                if (!world.isClient) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_CLUSTER_HIT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
            else if (!blockEntity.getStack(5).isEmpty()) {
                player.getInventory().offerOrDrop(blockEntity.getStack(5));
                blockEntity.removeStack(5);
                if (!world.isClient) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_CLUSTER_HIT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
            else if (!blockEntity.getStack(4).isEmpty()) {
                player.getInventory().offerOrDrop(blockEntity.getStack(4));
                blockEntity.removeStack(4);
                if (!world.isClient) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_CLUSTER_HIT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
            else if (!blockEntity.getStack(3).isEmpty()) {
                player.getInventory().offerOrDrop(blockEntity.getStack(3));
                blockEntity.removeStack(3);
                if (!world.isClient) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_CLUSTER_HIT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
            else if (!blockEntity.getStack(2).isEmpty()) {
                player.getInventory().offerOrDrop(blockEntity.getStack(2));
                blockEntity.removeStack(2);
                if (!world.isClient) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_CLUSTER_HIT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
            else if (!blockEntity.getStack(1).isEmpty()) {
                player.getInventory().offerOrDrop(blockEntity.getStack(1));
                blockEntity.removeStack(1);
                if (!world.isClient) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_CLUSTER_HIT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
            else if (!blockEntity.getStack(0).isEmpty()) {
                player.getInventory().offerOrDrop(blockEntity.getStack(0));
                blockEntity.removeStack(0);
                if (!world.isClient) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_CLUSTER_HIT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof Alloyery_Enchanter_BlockEntity) {
                ItemScatterer.spawn(world, pos, (Alloyery_Enchanter_BlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, TheBrimOfNatureBlockEntityRegistry.ALLOYERY_ENCHANTER_BLOCK_ENTITY,
                (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
