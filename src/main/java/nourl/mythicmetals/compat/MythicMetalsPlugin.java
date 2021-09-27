package nourl.mythicmetals.compat;


import dev.architectury.event.EventResult;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.entry.EntryRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.item.ItemStack;
import nourl.mythicmetals.MythicMetals;
import nourl.mythicmetals.config.OreConfig;
import nourl.mythicmetals.tools.MythicTools;
import nourl.mythicmetals.utils.FieldIterator;

import java.util.List;

public class MythicMetalsPlugin implements REIClientPlugin {

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerVisibilityPredicate((category, display) -> {
            if (display.getOutputEntries().stream().flatMap(List::stream)
                    .anyMatch(entryStack -> entryStack.getValue() instanceof ItemStack stack && stack.getItem() == MythicTools.Frogery.FROGE))
                return EventResult.interruptFalse();
            else return EventResult.pass();
        });
    }

    @Override
    public void registerEntries(EntryRegistry registry) {
        registry.removeEntry(EntryStacks.of(MythicTools.Frogery.FROGE));
        FieldIterator.iterateAccessibleFields(MythicMetals.CONFIG, OreConfig.class, (config, name) -> {
            if (!config.enabled) registry.removeEntryIf(entryStack ->
                    entryStack.getIdentifier().getNamespace().equals(MythicMetals.MOD_ID) && entryStack.getIdentifier().getPath().matches(".*(^|_)" + name + "($|_).*"));
        });
    }
}
