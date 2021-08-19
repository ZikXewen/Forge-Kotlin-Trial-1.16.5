package dezilaicosed.pay_ging

import dezilaicosed.pay_ging.core.init.ItemInit
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(PayGing.ID)
object PayGing {
    const val ID = "pay_ging"

    init {
        ItemInit.REGISTRY.register(MOD_BUS)
    }

    object TAB: ItemGroup(PayGing.ID){
        override fun makeIcon() = ItemStack(ItemInit.PAY_GING)
    }
}