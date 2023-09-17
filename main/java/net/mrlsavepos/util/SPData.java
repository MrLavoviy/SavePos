package net.mrlsavepos.util;

import net.minecraft.util.math.Vec3d;

public class SPData {
    public Vec3d pos;
    public String tip;
    public SPData(Vec3d pos, String tip) {
        this.pos = pos;
        this.tip = tip;
    }
}
