package dezilaicosed.pay_ging.common.item

import dezilaicosed.pay_ging.PayGing
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.Util
import net.minecraft.util.text.ITextComponent
import net.minecraft.util.text.StringTextComponent
import net.minecraft.util.text.TextFormatting
import net.minecraft.util.text.TranslationTextComponent
import net.minecraft.world.World

class PayGingItem: Item(Item.Properties().tab(PayGing.TAB)) {
    private val modes = mapOf<Float, String>(0F to "Pay Ging", 0.5F to "Pay", 1F to "Ging")
    override fun use(world: World, player: PlayerEntity, hand: Hand): ActionResult<ItemStack> {
        val stack = player.getItemInHand(hand)
        var mode = stack.orCreateTag.getFloat("mode")
        mode = (mode + 0.5F) % 1.5F
        stack.tag?.putFloat("mode", mode)
        if(world.isClientSide){
            player.sendMessage(TranslationTextComponent("message.pay_ging.pay_ging.change", modes[mode]), Util.NIL_UUID)
        }
        return ActionResult.success(stack)
    }
    fun getMode(stack: ItemStack) = if(stack.hasTag()) stack.tag?.getFloat("mode") else 0F
    override fun appendHoverText(stack: ItemStack, world: World?, tooltip: MutableList<ITextComponent>, flag: ITooltipFlag) {
        tooltip.add(TranslationTextComponent("tooltip.pay_ging.pay_ging", modes[getMode(stack)]).withStyle(TextFormatting.BLUE))
    }
}