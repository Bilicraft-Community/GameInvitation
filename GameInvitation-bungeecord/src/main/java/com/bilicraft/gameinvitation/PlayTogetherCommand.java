package com.bilicraft.gameinvitation;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PlayTogetherCommand extends Command {
    /**
     * Construct a new command with no permissions or aliases.
     */
    public PlayTogetherCommand() {
        super("playtogether");
    }

    /**
     * Execute this command with the specified sender and arguments.
     *
     * @param sender the executor of this command
     * @param args   arguments used to invoke this command
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!(sender instanceof ProxiedPlayer))
            return;
        String serverName = ((ProxiedPlayer) sender).getServer().getInfo().getName();
        TextComponent message = new TextComponent(sender.getName());
        message.setColor(ChatColor.YELLOW);
        TextComponent center = new TextComponent(" 邀请你一起玩: ");
        center.setColor(ChatColor.AQUA);
        TextComponent server = new TextComponent(serverName);
        server.setColor(ChatColor.YELLOW);
        TextComponent line1 = new TextComponent(message,center,server);
        TextComponent line2 = new TextComponent("[点击加入]");
        line2.setColor(ChatColor.GREEN);
        line2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/server "+serverName));
        ProxyServer.getInstance().broadcast(line1);
        ProxyServer.getInstance().broadcast(line2);
    }
}
