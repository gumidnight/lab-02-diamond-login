# Instructor reference

Students use the main branch. This branch includes the completed one-diamond behavior and verification tests; avoid opening the answer before the student has attempted the task.

Start from the same Hello World join handler used in Lab 1. Ask the student to identify the joining player and navigate the return type of getInventory(), then the addItem parameter. Let them use the Javadocs to choose the item material and quantity. Do not type the complete solution for them.

The required change is only one diamond added to the joining player's inventory. The greeting remains the baseline. No commands, permissions, config files, loops or starter-kit implementation are added.

Verify with spare inventory space. addItem can leave items uninserted when storage is full; overflow handling is outside this introductory task. Check inventory count rather than assuming a new slot appears, because the diamond can stack with existing diamonds.

Build the instructor version with `.\mvnw.cmd -Pverification verify`. Tests cover join, reconnect, two players, existing inventory, and the expected unfinished starter behavior. The test framework simulates Bukkit; the student should still follow the live Paper/Minecraft test steps in README.md.
