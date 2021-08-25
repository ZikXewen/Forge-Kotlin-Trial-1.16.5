package dezilaicosed.pay_ging.core.datagen

import dezilaicosed.pay_ging.PayGing
import dezilaicosed.pay_ging.core.init.ItemInit
import dezilaicosed.pay_ging.core.util.ClientSetup
import net.minecraft.data.DataGenerator
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.common.data.ExistingFileHelper

class Items(generator: DataGenerator, existingFileHelper: ExistingFileHelper) : ItemModelProvider(generator, PayGing.ID, existingFileHelper) {
    private val payGingItemPath = ItemInit.PAY_GING.registryName?.path
    private val payGingChestPath = ItemInit.PAY_GING_CHEST.registryName?.path
    override fun registerModels() {
        getBuilder(payGingItemPath)
            .parent(getExistingFile(mcLoc("item/generated")))
            .texture("layer0", "item/$payGingItemPath" + 0)
            .override().predicate(ClientSetup.MODE_PROPERTY, 0F).model(createPayGingModel(0)).end()
            .override().predicate(ClientSetup.MODE_PROPERTY, 0.5F).model(createPayGingModel(1)).end()
            .override().predicate(ClientSetup.MODE_PROPERTY, 1F).model(createPayGingModel(2)).end()

        withExistingParent(payGingChestPath, ResourceLocation(PayGing.ID, "block/$payGingChestPath"))
    }
    private fun createPayGingModel(mode: Int) =
        getBuilder(payGingItemPath + mode)
            .parent(getExistingFile(mcLoc("item/generated")))
            .texture("layer0", "item/$payGingItemPath$mode")
}
