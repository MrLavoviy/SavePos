package net.mrlsavepos.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.loader.impl.lib.sat4j.core.Vec;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.mrlsavepos.util.IPlayerDataSaver;
import net.mrlsavepos.util.PosData;
import net.mrlsavepos.util.SPData;

public class PosCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess access, CommandManager.RegistrationEnvironment environment) {
        dispatcher.register(((CommandManager.literal("pos").then(CommandManager.literal("set").then(CommandManager.argument("number", IntegerArgumentType.integer(1, 32)).then(CommandManager.argument("tip", StringArgumentType.string()).executes((context) -> {
            return execute((ServerCommandSource)context.getSource(), true, IntegerArgumentType.getInteger(context, "number"), StringArgumentType.getString(context, "tip"));
        })))))));
        dispatcher.register(((CommandManager.literal("pos").then(CommandManager.literal("get").then(CommandManager.argument("number", IntegerArgumentType.integer(1, 32)).executes((context) -> {
            return execute((ServerCommandSource)context.getSource(), false, IntegerArgumentType.getInteger(context, "number"), "");
        }))))));
    }

    private static int execute(ServerCommandSource source, boolean set, int number, String tip) {
        if (set) {
            if (source.getPlayer() != null) {
                Vec3d ppos = source.getPlayer().getPos();
                Vec3d pos = new Vec3d(Math.round(ppos.x + 0.5d), Math.round(ppos.y), Math.round(ppos.z + 0.5d));
                PosData.setPos((IPlayerDataSaver)source.getPlayer(), number, new SPData(pos, tip));
                source.sendMessage(Text.translatable("poscommand.cell").append(Text.literal(" " + number + ": " + Double.toString(pos.x) + " " + Double.toString(pos.y) + " "
                        + Double.toString(pos.z))));
                source.sendMessage(Text.translatable("poscommand.tip").append(Text.literal(": " + tip)));
                return 1;
            }
            source.sendMessage(Text.translatable("poscommand.unknownplayer"));
            return -1;
        } if (source.getPlayer() != null) {
            SPData dat = PosData.getPos((IPlayerDataSaver)source.getPlayer(), number);
            if (dat.pos.x != 0.0d && dat.pos.y != 0.0d && dat.pos.z != 0.0d && dat.tip != "") {
                source.sendMessage(Text.translatable("poscommand.cell").append(Text.literal(" " + number + ": " + Double.toString(dat.pos.x) + " " + Double.toString(dat.pos.y)
                        + " " + Double.toString(dat.pos.z))));
                source.sendMessage(Text.translatable("poscommand.tip").append(Text.literal(": " + dat.tip)));
                return 1;
            }
            source.sendMessage(Text.translatable("poscommand.nocell"));
            return 0;
        }
        source.sendMessage(Text.translatable("poscommand.unknownplayer"));
        return -1;
    }
}
