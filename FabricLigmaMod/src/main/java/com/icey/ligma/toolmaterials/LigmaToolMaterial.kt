package com.icey.ligma.toolmaterials

import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
object LigmaToolMaterial : ToolMaterial {

    override fun getDurability(): Int {
        return Int.MAX_VALUE
    }

    override fun getMiningSpeedMultiplier(): Float {
        return Float.MAX_VALUE
    }

    override fun getAttackDamage(): Float {
        return Float.MAX_VALUE
    }

    override fun getMiningLevel(): Int {
        return Int.MAX_VALUE
    }

    override fun getEnchantability(): Int {
        return Int.MAX_VALUE
    }

    override fun getRepairIngredient(): Ingredient? {
        return null
    }

}