# Lab 02: Diamond on Join

## Goal

Modify the plugin so that when a player joins the server, they receive **1 diamond**. Keep the existing Hello World greeting. This is the completed instructor reference. Give students the main branch, not this instructor branch.

## Requirements

JDK 25, VS Code with Microsoft's Extension Pack for Java, Git, Paper 1.21.11 running on Java 25, and Minecraft Java Edition 1.21.11. Maven Wrapper is included; do not install Maven separately.

## Open

```powershell
git clone https://github.com/gumidnight/lab-02-diamond-login.git
cd lab-02-diamond-login
code .
```

Check `java -version` and `javac -version` show 25. Open the entire folder in VS Code.

## Teaching sequence

1. Build and run the starter once. It should still show `Hello World!` when you join.
2. Open `src/main/java/HelloWorld.java` and find the join handler and its TODO.
3. Open the [Paper 1.21.11 Javadocs](https://jd.papermc.io/paper/1.21.11/).
4. Start with [Player](https://jd.papermc.io/paper/1.21.11/org/bukkit/entity/Player.html). Find `getInventory()` under inherited methods from HumanEntity and follow its return type to PlayerInventory.
5. Follow [PlayerInventory](https://jd.papermc.io/paper/1.21.11/org/bukkit/inventory/PlayerInventory.html) to inherited `addItem(...)` on [Inventory](https://jd.papermc.io/paper/1.21.11/org/bukkit/inventory/Inventory.html). Check which item type it expects.
6. Look at [ItemStack](https://jd.papermc.io/paper/1.21.11/org/bukkit/inventory/ItemStack.html) and [Material](https://jd.papermc.io/paper/1.21.11/org/bukkit/Material.html). Find DIAMOND and the way to specify quantity 1. Add the necessary imports yourself.
7. Write the missing action in the join handler, then save.
8. Run `.\build-plugin.bat` from the repository root. For diagnostic Maven output, run `.\mvnw.cmd package`.
9. Stop the Paper server. Replace the earlier HelloWorld JAR in its `plugins` folder with `target/HelloWorld-1.0.0.jar`. Keep only one HelloWorld JAR there. Start the server.
10. Join with space in your inventory. Compare the diamond count before and after: it should increase by exactly 1. Reconnect: the count should increase by 1 again. A second player should receive their own diamond.

Lab 2 is an independent project producing `HelloWorld-1.0.0.jar`. Lab 1 is unchanged and produces `HelloWorld-1.0.1.jar`. The plugin name/main class are the same, so replace the old JAR rather than loading both.

## Optional challenges

After the main task works, personalize the welcome using the player's username, try a kit containing 5 diamonds, 1 iron sword, 16 bread and 32 oak planks, then combine the welcome and kit. These are optional tasks, not part of the required Lab 2 implementation.
