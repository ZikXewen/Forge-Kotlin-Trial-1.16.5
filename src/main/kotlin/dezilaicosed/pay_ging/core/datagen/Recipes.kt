package dezilaicosed.pay_ging.core.datagen

import dezilaicosed.pay_ging.core.init.ItemInit
import net.minecraft.data.DataGenerator
import net.minecraft.data.IFinishedRecipe
import net.minecraft.data.RecipeProvider
import net.minecraft.data.ShapedRecipeBuilder
import net.minecraft.item.Items
import java.util.function.Consumer

class Recipes(generator: DataGenerator) : RecipeProvider(generator) {
    override fun buildShapelessRecipes(consumer: Consumer<IFinishedRecipe>) {
        ShapedRecipeBuilder.shaped(ItemInit.PAY_GING)
            .pattern(" x ")
            .pattern("x x")
            .pattern(" x ")
            .define('x', Items.SMOOTH_STONE)
            .group("pay_ging")
            .unlockedBy("smooth_stone", has(Items.SMOOTH_STONE))
            .save(consumer)

        ShapedRecipeBuilder.shaped(ItemInit.PAY_GING_CHEST)
            .pattern("xxx")
            .pattern("x x")
            .pattern("xxx")
            .define('x', ItemInit.PAY_GING)
            .group("pay_ging")
            .unlockedBy("pay_ging", has(ItemInit.PAY_GING))
            .save(consumer)
    }
}
