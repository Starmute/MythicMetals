package nourl.mythicmetals.tools;

import com.google.common.base.Suppliers;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import nourl.mythicmetals.item.MythicItems;

import java.util.function.Supplier;

public enum ToolMaterials implements ToolMaterial {
    ADAMANTITE(4, 1024, 7.0F, 5F, 16, () -> {
        return Ingredient.ofItems(MythicItems.ADAMANTITE_INGOT);
    }),
    AQUARIUM(2, 455, 6.5F, 2.0F, 12, () -> {
        return Ingredient.ofItems(MythicItems.AQUARIUM_INGOT);
    }),
    BANGLUM(2, 260, 11.0F, 2.0F, 1, () -> {
        return Ingredient.ofItems(MythicItems.BANGLUM_INGOT);
    }),
    BRONZE(2, 624, 6.0F, 2.5F, 14, () -> {
        return Ingredient.ofItems(MythicItems.BRONZE_INGOT);
    }),
    CARMOT(3, 730, 11.5F, 2.0F, 42, () -> {
        return Ingredient.ofItems(MythicItems.CARMOT_INGOT);
    }),
    CELESTIUM(4, 2270, 16.9F, 6.0F, 24, () -> {
        return Ingredient.ofItems(MythicItems.CELESTIUM_INGOT);
    }),
    COPPER(1, 125, 5.0F, 1.0F, 8, () -> {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }),
    DURASTEEL(3, 800, 7.0F, 3.5F, 12, () -> {
        return Ingredient.ofItems(MythicItems.DURASTEEL_INGOT);
    }),
    HALLOWED(4, 1562, 12.0F, 5.0F, 20, () -> {
        return Ingredient.ofItems(MythicItems.HALLOWED_INGOT);
    }),
    KYBER(2, 889, 7.0F, 2.5F, 20, () -> {
        return Ingredient.ofItems(MythicItems.KYBER_INGOT);
    }),
    METALLURGIUM(5, 3000, 15.0F, 7.0F, 30, () -> {
        return Ingredient.ofItems(MythicItems.METALLURGIUM_INGOT);
    }),
    MYTHRIL(4, 1024, 13.0F, 3.0F, 22, () -> {
        return Ingredient.ofItems(MythicItems.MYTHRIL_INGOT);
    }),
    ORICHALCUM(4, 2048, 6.0F, 4.0F, 16, () -> {
        return Ingredient.ofItems(MythicItems.ORICHALCUM_INGOT);
    }),
    OSMIUM(3, 584, 7.0F, 2.0F, 13, () -> {
        return Ingredient.ofItems(MythicItems.OSMIUM_INGOT);
    }),
    PALLADIUM(4, 1234, 8.0F, 3.5F, 16, () -> {
        return Ingredient.ofItems(MythicItems.PALLADIUM_INGOT);
    }),
    PROMETHEUM(3, 1572, 6.0F, 4.0F, 15, () -> {
        return Ingredient.ofItems(MythicItems.PROMETHEUM_INGOT);
    }),
    QUADRILLUM(2, 321, 5.0F, 2.5F, 8, () -> {
        return Ingredient.ofItems(MythicItems.QUADRILLUM_INGOT);
    }),
    RUNITE(3, 1337, 6.9F, 3.3F, 13, () -> {
        return Ingredient.ofItems(MythicItems.RUNITE_INGOT);
    }),
    STAR_PLATINUM(3, 1300, 9.0F, 3.0F, 18, () -> {
        return Ingredient.ofItems(MythicItems.STAR_PLATINUM);
    }),
    STEEL(3, 600, 7.0F, 2.5F, 11, () -> {
        return Ingredient.ofItems(MythicItems.STEEL_INGOT);
    }),
    STORMYX(3, 1305, 8.0F, 3.5F, 20, () -> {
        return Ingredient.ofItems(MythicItems.STORMYX_INGOT);
    });


    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeedMultiplier;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ToolMaterials(int miningLevel, int itemDurability, float miningSpeedMultiplier, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeedMultiplier = miningSpeedMultiplier;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeedMultiplier;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
