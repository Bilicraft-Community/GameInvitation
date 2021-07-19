package com.bilicraft.gameinvitation;

import net.md_5.bungee.api.plugin.Plugin;

public final class GameInvitationBungeeCord extends Plugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getProxy().getPluginManager().registerCommand(this,new PlayTogetherCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getProxy().unregisterChannel("gameinvite:invite");
    }
}
