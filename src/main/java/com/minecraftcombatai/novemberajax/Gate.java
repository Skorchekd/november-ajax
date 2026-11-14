package com.minecraftcombatai.novemberajax;

import net.minecraft.client.Minecraft;
import net.minecraft.client.server.IntegratedServer;

/**
 * Where AJAX may play. He is a practice partner, not a client for servers:
 *
 *   - only in a singleplayer world on this computer (the integrated server), never one opened to LAN, never a server;
 *   - when he plays for you, only against this mod's own practice bots (or monsters, if switched on), never a player.
 *
 * His aim is raw on purpose (a robot's aim, nothing that passes for a human's), and these rules are why the mod is useful for
 * practice and useless for cheating.
 */
final class Gate {
    private Gate() {}

    static boolean allowed(Minecraft mc) {
        IntegratedServer s = mc.getSingleplayerServer();
        return s != null && mc.hasSingleplayerServer() && !s.isPublished() && mc.getConnection() != null
                && mc.getConnection().getConnection().isMemoryConnection();
    }

    static String refusal() {
        return "AJAX only plays in a singleplayer world on this computer (not LAN, not servers).";
    }
}
