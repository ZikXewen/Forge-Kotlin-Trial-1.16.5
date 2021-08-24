package dezilaicosed.pay_ging.core.init

import dezilaicosed.pay_ging.PayGing
import dezilaicosed.pay_ging.common.item.PayGingItem
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object ItemInit {
    val REGISTRY = KDeferredRegister(ForgeRegistries.ITEMS, PayGing.ID)

    val PAY_GING by REGISTRY.registerObject("pay_ging", ::PayGingItem)
    val PAY_GING_CHEST by REGISTRY.registerObject("pay_ging_chest"){
        BlockItem(BlockInit.PAY_GING_CHEST, Item.Properties().tab(PayGing.TAB))
    }
}