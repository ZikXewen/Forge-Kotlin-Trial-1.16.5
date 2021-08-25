package dezilaicosed.pay_ging.core.datagen

import dezilaicosed.pay_ging.PayGing
import dezilaicosed.pay_ging.core.init.BlockInit
import net.minecraft.data.DataGenerator
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.util.Direction
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.model.generators.BlockStateProvider
import net.minecraftforge.client.model.generators.ConfiguredModel
import net.minecraftforge.common.data.ExistingFileHelper

class BlockStates(generator: DataGenerator, existingFileHelper: ExistingFileHelper) : BlockStateProvider(generator, PayGing.ID, existingFileHelper) {
    override fun registerStatesAndModels() {
        val payGingChestSide = ResourceLocation(PayGing.ID, "block/pay_ging_block")
        val payGingChestFront = ResourceLocation(PayGing.ID, "block/pay_ging_chest_front")
        val payGingChestLit = ResourceLocation(PayGing.ID, "block/pay_ging_chest_lit")

        getVariantBuilder(BlockInit.PAY_GING_CHEST).forAllStates{
            val dir = it.getValue(BlockStateProperties.FACING)
            ConfiguredModel.builder()
                .modelFile(
                    if (it.getValue(BlockStateProperties.POWERED))
                        models().cube("pay_ging_chest_lit", payGingChestSide, payGingChestSide, payGingChestLit, payGingChestSide, payGingChestSide, payGingChestSide)
                    else
                        models().cube("pay_ging_chest", payGingChestSide, payGingChestSide, payGingChestFront, payGingChestSide, payGingChestSide, payGingChestSide)
                )
                .rotationX(if (dir.axis == Direction.Axis.Y) dir.axisDirection.step * -90 else 0)
                .rotationY(if (dir.axis != Direction.Axis.Y) ((dir.get2DDataValue() + 2) % 4) * 90 else  0)
                .build()
        }
    }

}
