import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.*;
import org.mockbukkit.mockbukkit.MockBukkit;
import org.mockbukkit.mockbukkit.ServerMock;
import org.mockbukkit.mockbukkit.entity.PlayerMock;
import static org.junit.jupiter.api.Assertions.*;

class DiamondJoinTest {
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
    @Test void joinGivesExactlyOneDiamondAndKeepsGreeting() {
        join(alex);
        assertEquals(1, diamonds(alex));
        alex.assertSaid("Hello World!");
        assertEquals(0, diamonds(sam));
    }
    @Test void reconnectAddsOneMoreDiamond() {
        join(alex); join(alex);
        assertEquals(2, diamonds(alex));
    }
    @Test void eachJoiningPlayerGetsTheirOwnDiamond() {
        join(alex); join(sam);
        assertEquals(1, diamonds(alex));
        assertEquals(1, diamonds(sam));
    }
    @Test void addsToExistingDiamondsWithoutReplacingOtherItems() {
        alex.getInventory().setItem(0, new ItemStack(Material.DIAMOND, 7));
        alex.getInventory().setItem(1, new ItemStack(Material.BREAD, 16));
        join(alex);
        assertEquals(8, diamonds(alex));
        assertEquals(Material.BREAD, alex.getInventory().getItem(1).getType());
        assertEquals(16, alex.getInventory().getItem(1).getAmount());
    }
}
