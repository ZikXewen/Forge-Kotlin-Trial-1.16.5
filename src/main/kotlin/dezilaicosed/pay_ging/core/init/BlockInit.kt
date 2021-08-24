package dezilaicosed.pay_ging.core.init

import dezilaicosed.pay_ging.PayGing
import dezilaicosed.pay_ging.common.block.PayGingChest
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object BlockInit {
    val REGISTRY = KDeferredRegister(ForgeRegistries.BLOCKS, PayGing.ID)

    val PAY_GING_CHEST by REGISTRY.registerObject("pay_ging_chest", ::PayGingChest)
}