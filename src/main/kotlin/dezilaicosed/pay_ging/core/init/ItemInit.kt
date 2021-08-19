package dezilaicosed.pay_ging.core.init

import dezilaicosed.pay_ging.PayGing
import net.minecraft.item.Item
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object ItemInit {
    val REGISTRY = KDeferredRegister(ForgeRegistries.ITEMS, PayGing.ID)

    val PAY_GING by REGISTRY.registerObject("pay_ging"){
        Item(Item.Properties().tab(PayGing.TAB))
    }
}