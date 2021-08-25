package dezilaicosed.pay_ging.core.util

import dezilaicosed.pay_ging.PayGing
import dezilaicosed.pay_ging.core.init.ItemInit
import net.minecraft.item.ItemModelsProperties
import net.minecraft.util.ResourceLocation
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent

@Mod.EventBusSubscriber(modid = PayGing.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
object ClientSetup {

    val MODE_PROPERTY = ResourceLocation(PayGing.ID, "mode")

    @SubscribeEvent
    fun setup(event: FMLClientSetupEvent){
        event.enqueueWork(::payGingItemOverrides)
    }

    private fun payGingItemOverrides() {
        val item = ItemInit.PAY_GING
        ItemModelsProperties.register(item, MODE_PROPERTY) {stack, _, _ -> item.getMode(stack) as Float}
    }
}