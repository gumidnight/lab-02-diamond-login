# Verification record

Candidate: Lab 2 instructor solution, Paper API 1.21.11, JDK 25.0.4 on Windows.

Scope: add exactly one diamond to the joining player, retaining the existing greeting. No optional challenge code added. Lab 1 byte hashes are unchanged.

Automated checks:
- Student verification: mvnw.cmd -Pverification verify, 1 starter test passed.
- Instructor verification: mvnw.cmd -Pverification verify, 4 behavior tests passed.
- Both projects: build-plugin.bat passed, producing target/HelloWorld-1.0.0.jar.

Scenarios: first join gives one diamond and greeting; reconnect adds one more; a different player gets their own diamond; existing diamonds increase by one and bread remains unchanged. All passed in MockBukkit 4.116.3.

Limitations: MockBukkit simulates Bukkit; no human Minecraft client session was run. Follow the live server test instructions in README.md before class. Use spare inventory space; handling a full inventory is outside this lab requirement.

Verdict: automated behavior and build checks passed; live-client validation remains a manual check.
