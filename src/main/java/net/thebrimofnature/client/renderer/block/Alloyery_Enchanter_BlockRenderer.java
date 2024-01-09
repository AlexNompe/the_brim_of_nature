package net.thebrimofnature.client.renderer.block;

import net.thebrimofnature.block.entity.Alloyery_Enchanter_BlockEntity;
import net.thebrimofnature.client.model.block.Alloyery_Enchanter_BlockModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class Alloyery_Enchanter_BlockRenderer extends GeoBlockRenderer<Alloyery_Enchanter_BlockEntity> {
    public Alloyery_Enchanter_BlockRenderer() {
        super(new Alloyery_Enchanter_BlockModel());
    }
}