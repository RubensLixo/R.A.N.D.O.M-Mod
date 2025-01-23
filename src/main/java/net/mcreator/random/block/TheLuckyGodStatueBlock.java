
package net.mcreator.random.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class TheLuckyGodStatueBlock extends Block implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public TheLuckyGodStatueBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(3, 0, 4, 13, 15, 12), box(13, 4, 4, 16, 8, 11), box(0, 4, 4, 3, 8, 11), box(9, 15, 5, 10, 16, 7), box(6, 15, 5, 7, 16, 7), box(10, 15, 6, 11, 16, 7), box(5, 15, 6, 6, 16, 7), box(9, 15, 9, 10, 16, 11),
					box(6, 15, 9, 7, 16, 11), box(7, 15, 7, 9, 16, 9), box(10, 15, 9, 11, 16, 10), box(5, 15, 9, 6, 16, 10));
			case NORTH -> Shapes.or(box(3, 0, 4, 13, 15, 12), box(0, 4, 5, 3, 8, 12), box(13, 4, 5, 16, 8, 12), box(6, 15, 9, 7, 16, 11), box(9, 15, 9, 10, 16, 11), box(5, 15, 9, 6, 16, 10), box(10, 15, 9, 11, 16, 10), box(6, 15, 5, 7, 16, 7),
					box(9, 15, 5, 10, 16, 7), box(7, 15, 7, 9, 16, 9), box(5, 15, 6, 6, 16, 7), box(10, 15, 6, 11, 16, 7));
			case EAST -> Shapes.or(box(4, 0, 3, 12, 15, 13), box(4, 4, 0, 11, 8, 3), box(4, 4, 13, 11, 8, 16), box(5, 15, 6, 7, 16, 7), box(5, 15, 9, 7, 16, 10), box(6, 15, 5, 7, 16, 6), box(6, 15, 10, 7, 16, 11), box(9, 15, 6, 11, 16, 7),
					box(9, 15, 9, 11, 16, 10), box(7, 15, 7, 9, 16, 9), box(9, 15, 5, 10, 16, 6), box(9, 15, 10, 10, 16, 11));
			case WEST -> Shapes.or(box(4, 0, 3, 12, 15, 13), box(5, 4, 13, 12, 8, 16), box(5, 4, 0, 12, 8, 3), box(9, 15, 9, 11, 16, 10), box(9, 15, 6, 11, 16, 7), box(9, 15, 10, 10, 16, 11), box(9, 15, 5, 10, 16, 6), box(5, 15, 9, 7, 16, 10),
					box(5, 15, 6, 7, 16, 7), box(7, 15, 7, 9, 16, 9), box(6, 15, 10, 7, 16, 11), box(6, 15, 5, 7, 16, 6));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public PathType getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return PathType.BLOCKED;
	}
}
