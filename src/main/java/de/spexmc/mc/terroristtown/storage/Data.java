package de.spexmc.mc.terroristtown.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import de.spexmc.mc.terroristtown.io.sql.SQLManager;
import de.spexmc.mc.terroristtown.model.Tester;

/**
 * Created by Lara on 26.02.2019 for terroristtown
 */
public final class Data {
  private static Data instance;
  private static boolean forceDisable;

  /**
   * Singleton-Muster: nur eine Instanz im gesamten Programm
   *
   * @return Instanz
   */
  public static Data getInstance() {
    if (instance == null) {
      instance = new Data();
    }
    return instance;
  }

  public static boolean isForceDisable() {
    return forceDisable;
  }

  public static void setForceDisable(boolean forceDisable) {
    Data.forceDisable = forceDisable;
  }

  private final Map<UUID, String> cache;
  private final SQLManager sql;
  private final Tester tester;
  private final TTTInfo tttInfo;

  private Data() {
    this.cache = new HashMap<>();
    this.sql = new SQLManager();
    this.tester = new Tester();
    this.tttInfo = new TTTInfo();
    forceDisable = false;
  }

  //<editor-fold desc="getter and setter">
  public Map<UUID, String> getCache() {
    return cache;
  }

  public SQLManager getSql() {
    return sql;
  }

  public Tester getTester() {
    return tester;
  }

  public TTTInfo getTTTInfo() {
    return tttInfo;
  }

  //</editor-fold>
}
