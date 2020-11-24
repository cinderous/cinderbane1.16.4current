package net.cinderous.cinderbane.tileentity;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.RegistryHandler;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class CinderwormBaseTileEntity extends TileEntity implements ITickableTileEntity {

    private int ticks;

    public CinderwormBaseTileEntity() {
        super(RegistryHandler.CINDERWORM_HEAD_TILE_ENTITY.get());
    }


    @Override
    public void tick() {
        ticks++;
        if (ticks == 20) {
            ticks = 0;
            Cinderbane.LOGGER.info("Cinderworm Base is Active");
        }
    }

}