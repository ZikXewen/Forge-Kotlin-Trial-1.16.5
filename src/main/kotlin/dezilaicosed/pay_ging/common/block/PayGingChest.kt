package dezilaicosed.pay_ging.common.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.item.BlockItemUseContext
import net.minecraft.item.ItemStack
import net.minecraft.state.StateContainer
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.util.text.ITextComponent
import net.minecraft.util.text.TextFormatting
import net.minecraft.util.text.TranslationTextComponent
import net.minecraft.world.IBlockReader

class PayGingChest: Block(Properties.of(Material.STONE).sound(SoundType.STONE).strength(2.5F)){
    override fun createBlockStateDefinition(builder: StateContainer.Builder<Block, BlockState>) {
        builder.add(BlockStateProperties.FACING, BlockStateProperties.POWERED)
    }
    override fun getStateForPlacement(context: BlockItemUseContext): BlockState? {
        return defaultBlockState().setValue(BlockStateProperties.FACING, context.nearestLookingDirection.opposite)
    }
    override fun appendHoverText(stack: ItemStack, reader: IBlockReader?, tooltip: MutableList<ITextComponent>, flag: ITooltipFlag) {
        tooltip.add(TranslationTextComponent("tooltip.pay_ging.pay_ging_chest").withStyle(TextFormatting.BLUE))
    }

}