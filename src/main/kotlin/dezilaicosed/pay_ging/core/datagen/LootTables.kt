package dezilaicosed.pay_ging.core.datagen

import com.google.gson.GsonBuilder
import dezilaicosed.pay_ging.core.init.BlockInit
import net.minecraft.block.Block
import net.minecraft.data.DataGenerator
import net.minecraft.data.DirectoryCache
import net.minecraft.data.IDataProvider
import net.minecraft.data.LootTableProvider
import net.minecraft.loot.*
import net.minecraft.loot.functions.CopyName
import net.minecraft.loot.functions.CopyNbt
import net.minecraft.loot.functions.SetContents
import net.minecraft.util.ResourceLocation
import java.io.IOException

//https://github.com/McJty/YouTubeTutorial17/blob/b2e6eeee512028ac113b7a4c666e1c0ace25cff6/src/main/java/com/mcjty/datagen/LootTables.java
//Removed Energy Functionality
class LootTables(generator: DataGenerator): LootTableProvider(generator){
    private val generator = generator
    private val gson = GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create()
    override fun run(cache: DirectoryCache) {
        val tables = HashMap<ResourceLocation, LootTable>()
        tables[BlockInit.PAY_GING_CHEST.lootTable] = createStandardTable("pay_ging_chest", BlockInit.PAY_GING_CHEST).setParamSet(LootParameterSets.BLOCK).build()
        writeTables(cache, tables)
    }
    private fun createStandardTable(name: String, block: Block) = LootTable.lootTable().withPool(
        LootPool.lootPool().name(name)
            .setRolls(ConstantRange.exactly(1))
            .add(ItemLootEntry.lootTableItem(block)
                .apply(CopyName.copyName(CopyName.Source.BLOCK_ENTITY))
                .apply(CopyNbt.copyData(CopyNbt.Source.BLOCK_ENTITY).copy("inv", "BlockEntityTag.inv", CopyNbt.Action.REPLACE))
                .apply(SetContents.setContents().withEntry(DynamicLootEntry.dynamicEntry(ResourceLocation("minecraft", "contents"))))
            )
    )
    private fun writeTables(cache: DirectoryCache, tables: Map<ResourceLocation, LootTable>){
        tables.forEach { (key, lootTable) ->
            IDataProvider.save(gson, cache, LootTableManager.serialize(lootTable),
                generator.outputFolder.resolve("data/" + key.namespace + "/loot_tables/" + key.path + ".json"))
        } // Uncaught, yet
    }
    override fun getName() = "Pay Ging Loottables"
}