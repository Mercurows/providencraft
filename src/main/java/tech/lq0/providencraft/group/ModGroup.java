package tech.lq0.providencraft.group;

import net.minecraft.item.ItemGroup;

public class ModGroup {
    public static final ItemGroup itemgroup = new ProvidencraftGroup();
    public static final ProvidencraftBlockGroup blockgroup = new ProvidencraftBlockGroup();
    public static final ProvidencraftCostumeGroup costumegroup = new ProvidencraftCostumeGroup();
    public static final ProvidencraftDonateGroup donategroup = new ProvidencraftDonateGroup();
    public static final ProvidencraftTapeGroup tapegroup = new ProvidencraftTapeGroup();
    public static ProvidencraftIntegrationGroup integrationgroup;

    public static void initIntegrationGroup() {
        integrationgroup = new ProvidencraftIntegrationGroup();
    }
}
