package de.spexmc.mc.terroristtown.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import de.spexmc.mc.terroristtown.model.TTTPlayer;
import de.spexmc.mc.terroristtown.storage.Data;
import de.spexmc.mc.terroristtown.storage.Messages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Lara on 20.07.2019 for terroristtown
 */
public final class Messenger {
  private static final Logger logger;

  static {
    logger = Logger.getLogger(Messenger.class.getName());
  }

  public static void administratorMessage(String msg) {
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (player.isOp()) {
        sendMessage(player, "&a&l" + msg);
      }
    }

    logger.log(Level.INFO, msg);
  }

  public static void sendMessage(Player player, String msg) {
    player.sendMessage(Messages.PREFIX + msg);
  }

  public static void sendTeamMessage(TTTPlayer player, String msg) {
    for (TTTPlayer tttPlayer : Data.getInstance().getTTTInfo().getPlayers().keySet()) {
      if (tttPlayer.getRole().equals(player.getRole())) {
        tttPlayer.getPlayer().sendMessage("§a[TEAMCHAT] §7" + msg);
      }
    }
  }

  public static void broadcast(String msg) {
    Bukkit.broadcastMessage(Messages.PREFIX + msg);
  }

}
