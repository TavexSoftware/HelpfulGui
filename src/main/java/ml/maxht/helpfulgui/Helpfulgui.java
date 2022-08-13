package ml.maxht.helpfulgui;

import ml.maxht.helpfulgui.Commands.adminguicommand;
import ml.maxht.helpfulgui.Commands.killgui;
import org.bukkit.plugin.java.JavaPlugin;

public final class Helpfulgui extends JavaPlugin {

    private static Helpfulgui plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("killgui").setExecutor(new killgui());
        getCommand("admingui").setExecutor(new adminguicommand());
        // Do everything else first
        System.out.printf("HelpfulGui Has Started");
        // End Of onEnable
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("HelpfulGui Has Stopped");
    }
}
