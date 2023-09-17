package net.mrlsavepos.util;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.math.Vec3d;

public class PosData {
    public static int setPos(IPlayerDataSaver player, int number, SPData dat) {
        NbtCompound nbt = player.getPosData();
        nbt.putDouble(("ax" + Integer.toString(number - 1)), dat.pos.x);
        nbt.putDouble(("ay" + Integer.toString(number - 1)), dat.pos.y);
        nbt.putDouble(("az" + Integer.toString(number - 1)), dat.pos.z);
        nbt.putString(("as" + Integer.toString(number - 1)), dat.tip);
        return 1;
    }
    public static SPData getPos(IPlayerDataSaver player, int number) {
        NbtCompound nbt = player.getPosData();
        Vec3d pos = new Vec3d(nbt.getDouble("ax" + Integer.toString(number - 1)), nbt.getDouble("ay" + Integer.toString(number - 1)), nbt.getDouble("az" + Integer.toString(number - 1)));
        SPData dat = new SPData(pos, nbt.getString("as" + Integer.toString(number - 1)));
        return dat;
    }
}
