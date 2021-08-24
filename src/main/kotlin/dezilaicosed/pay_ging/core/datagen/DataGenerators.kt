package dezilaicosed.pay_ging.core.datagen

import dezilaicosed.pay_ging.PayGing
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent

@Mod.EventBusSubscriber(modid = PayGing.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
object DataGenerators {
    @SubscribeEvent
    fun gatherData(event: GatherDataEvent){
        var generator = event.generator
        if(event.includeClient()){
            generator.addProvider(Items(generator, event.existingFileHelper))
        }
    }
}