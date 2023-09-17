package net.mrlsavepos.mixin;

import net.minecraft.nbt.NbtCompound;
import net.mrlsavepos.util.IPlayerDataSaver;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class PlayerDataSaverMixin implements IPlayerDataSaver {
    private NbtCompound posData;
    @Override
    public NbtCompound getPosData() {
        if (this.posData == null) {
            this.posData = new NbtCompound();
        }
        return posData;
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable info) {
        if(posData != null) {
            nbt.put("savepos.pos_data", posData);
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo info) {
        if (nbt.contains("savepos.pos_data", 10)) {
            posData = nbt.getCompound("savepos.pos_data");
        }
    }
}
