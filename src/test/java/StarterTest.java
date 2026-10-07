import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.*;
import org.mockbukkit.mockbukkit.MockBukkit;
import org.mockbukkit.mockbukkit.ServerMock;
import org.mockbukkit.mockbukkit.entity.PlayerMock;
import static org.junit.jupiter.api.Assertions.*;

class StarterTest {
    private ServerMock server;
    private PlayerMock alex;
    private PlayerMock sam;
    @BeforeEach void setup() {
        server = MockBukkit.mock();
        alex = server.addPlayer("Alex");
        sam = server.addPlayer("Sam");
        MockBukkit.load(HelloWorld.class);
    }
    @AfterEach void cleanup() { MockBukkit.unmock(); }
    private void join(PlayerMock player) {
        server.getPluginManager().callEvent(new PlayerJoinEvent(player, Component.empty()));
    }
    private int diamonds(PlayerMock player) {
        int count = 0;
        for (ItemStack item : player.getInventory().getStorageContents()) {
            if (item != null && item.getType() == Material.DIAMOND) count += item.getAmount();
        }
        return count;
    }
    @Test void unfinishedStarterStillGreetsButDoesNotGiveDiamond() {
        join(alex);
        alex.assertSaid("Hello World!");
        assertEquals(0, diamonds(alex));
    }
}
