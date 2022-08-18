package ml.maxht.helpfulgui;

import ml.maxht.helpfulgui.Commands.admingui;
import ml.maxht.helpfulgui.Commands.killgui;
import ml.maxht.helpfulgui.Listeners.admin.banplayer;
import ml.maxht.helpfulgui.Listeners.adminlistener;
import ml.maxht.helpfulgui.Listeners.killlistener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Helpfulgui extends JavaPlugin {

    private static Helpfulgui plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        if (getConfig().getString("killguidisabledmessage") == null){
            System.out.println("Your config is invalid!");
            getServer().getPluginManager().disablePlugin(this);
        }
        getCommand("killgui").setExecutor(new killgui());
        getServer().getPluginManager().registerEvents(new killlistener(), this);
        getCommand("admin").setExecutor(new admingui());
        getServer().getPluginManager().registerEvents(new adminlistener(), this);
        getServer().getPluginManager().registerEvents(new banplayer(), this);
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
