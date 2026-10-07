import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HelloWorld extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Hello World!");
        // TODO: Give this joining player exactly 1 diamond.
        // Follow the Paper Javadocs: Player -> getInventory() -> addItem(...) -> ItemStack -> Material.
    }
}