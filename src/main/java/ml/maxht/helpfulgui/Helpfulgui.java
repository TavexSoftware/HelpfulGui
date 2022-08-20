package ml.maxht.helpfulgui;

import ml.maxht.helpfulgui.Commands.admingui;
import ml.maxht.helpfulgui.Commands.killgui;
import ml.maxht.helpfulgui.Listeners.admin.banplayer;
import ml.maxht.helpfulgui.Listeners.admin.kickplayer;
import ml.maxht.helpfulgui.Listeners.admin.tpplayer;
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
        getServer().getPluginManager().registerEvents(new adminlistener(), this);
        getServer().getPluginManager().registerEvents(new banplayer(), this);
        getServer().getPluginManager().registerEvents(new killlistener(), this);
        getServer().getPluginManager().registerEvents(new tpplayer(), this);
        getServer().getPluginManager().registerEvents(new kickplayer(), this);
        getCommand("killgui").setExecutor(new killgui());
        getCommand("admin").setExecutor(new admingui());
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
