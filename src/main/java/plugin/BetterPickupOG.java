package plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class BetterPickupOG extends JavaPlugin {

    // Declare variable to hold class for passing.
    private static BetterPickupOG plugin;

    // Declare fields.
    private boolean autoPickup;
    private int blockDropDelay;
    private boolean invulnerable;
    private int playerDropDelay;
    private int stealDelay;

    @Override
    public void onEnable() {

        // Config stuff.
        saveDefaultConfig();
        reload();

        // Assign the plugin variable to the main class instance.
        plugin = this;

        // Register command.
        getCommand("betterpickup").setExecutor(new ReloadCommand());

        // Listeners.
        getServer().getPluginManager().registerEvents(new DropListener(), this);

    }

    @Override
    public void onDisable() {

        this.getLogger().info("BetterPickup-OG shut down successfully.");

    }

    public void reload() {

        reloadConfig();

        autoPickup = getConfig().getBoolean("autoPickup");
        blockDropDelay = getConfig().getInt("blockDropDelay");
        invulnerable = getConfig().getBoolean("invulnerable");
        playerDropDelay = getConfig().getInt("playerDropDelay");
        stealDelay = getConfig().getInt("stealDelay");

    }

    // Class constructor.
    public static BetterPickupOG getPlugin() {

        // Pass instance of main to other classes.
        return plugin;

    }

    public boolean autoPickup() {

        return autoPickup;

    }

    public int blockDropDelay() {

        return blockDropDelay;

    }

    public boolean invulnerable() {

        return invulnerable;

    }

    public int playerDropDelay() {

        return playerDropDelay;

    }

    public int stealDelay() {

        return stealDelay;

    }

}
