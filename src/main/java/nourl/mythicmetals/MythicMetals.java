package nourl.mythicmetals;

import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import nourl.mythicmetals.armor.MythicArmor;
import nourl.mythicmetals.blocks.MythicBlocks;
import nourl.mythicmetals.config.EnchantConfig;
import nourl.mythicmetals.config.MythicConfig;
import nourl.mythicmetals.item.MythicItemGroups;
import nourl.mythicmetals.item.MythicItems;
import nourl.mythicmetals.registry.RegisterSounds;
import nourl.mythicmetals.tools.MythicTools;
import nourl.mythicmetals.utils.MythicCommands;
import nourl.mythicmetals.utils.RegistryHelper;
import nourl.mythicmetals.world.MythicOreFeatures;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MythicMetals implements ModInitializer {
    public static Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mythicmetals";
    public static final int CONFIG_VERSION = 3;

    public static MythicConfig CONFIG = AutoConfig.register(MythicConfig.class, GsonConfigSerializer::new).getConfig();

    public static final OwoItemGroup TABBED_GROUP = new MythicItemGroups(RegistryHelper.id("main"));


    @Override
    public void onInitialize() {
        RegisterSounds.register();
        FieldRegistrationHandler.processSimple(MythicTools.class, false);
        FieldRegistrationHandler.register(MythicItems.class, MOD_ID, false);
        FieldRegistrationHandler.processSimple(MythicArmor.class, false);
        MythicBlocks.init();
        MythicOreFeatures.init();
        MythicCommands.register();
        EnchantConfig.appendEnchants();
        TABBED_GROUP.initialize();

        LOGGER.info("[Mythic Metals] Mythic Metals is now initialized.");

        if (CONFIG.configVersion < CONFIG_VERSION) {
            LOGGER.info("[Mythic Metals] Your config is outdated. Please update it manually, or delete the file so it can be re-generated.");
        }

        if (FabricLoader.getInstance().isModLoaded("harvest_scythes")) {
            LOGGER.info("[Mythic Metals] I see HarvestScythes. I'll take care of DH so you don't have to");
        }
        if (FabricLoader.getInstance().isModLoaded("enhancedcraft")) {
            LOGGER.info("[Mythic Metals] Oh EnhancedCraft? If you ever see Spxctre tell him I said hi!");
        }
        if (FabricLoader.getInstance().isModLoaded("origins")) {
            LOGGER.info("[Mythic Metals] Have fun using Origins!");
            EnchantConfig.appendWaterProt();
        }
    }
}
