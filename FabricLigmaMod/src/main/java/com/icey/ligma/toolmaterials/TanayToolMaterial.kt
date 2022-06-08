package com.icey.ligma.toolmaterials

import net.minecraft.item.Items
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
object TanayToolMaterial : ToolMaterial {

    override fun getDurability(): Int {
        return 500
    }

    override fun getMiningSpeedMultiplier(): Float {
        return 100F
    }

    override fun getAttackDamage(): Float {
        return 100F
    }

    override fun getMiningLevel(): Int {
        return 3
    }

    override fun getEnchantability(): Int {
        return 100
    }

    override fun getRepairIngredient(): Ingredient {
        return Ingredient.ofItems(Items.CONDUIT)
    }

}