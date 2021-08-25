package dezilaicosed.pay_ging.core.datagen

import dezilaicosed.pay_ging.PayGing
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent

@Mod.EventBusSubscriber(modid = PayGing.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
object DataGenerators {
    @SubscribeEvent
    fun gatherData(event: GatherDataEvent){
        val generator = event.generator
        if(event.includeServer()){
            generator.addProvider(Recipes(generator))
            generator.addProvider(LootTables(generator))
        }
        if(event.includeClient()){
            //BlockStates has to come before Items
            generator.addProvider(BlockStates(generator, event.existingFileHelper))
            generator.addProvider(Items(generator, event.existingFileHelper))
        }
    }
}