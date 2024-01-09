package net.thebrimofnature.client.model.block;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.thebrimofnature.The_Brim_Of_Nature;
import net.thebrimofnature.block.entity.Alloyery_Enchanter_BlockEntity;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class Alloyery_Enchanter_BlockModel extends DefaultedBlockGeoModel<Alloyery_Enchanter_BlockEntity> {
    public Alloyery_Enchanter_BlockModel() {
        super(new Identifier(The_Brim_Of_Nature.MOD_ID, "alloyery_enchanter"));
    }
}