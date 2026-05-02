# 🎮 Happy Frontend

Happy Frontend is a **cross-platform multi-emulator game launcher** designed to organize and launch classic games from systems like PS1, PS2, SNES, NES, and more using external emulators such as RetroArch and PCSX2.

It supports:
- 📱 Android (Kotlin)
- 🖥️ Windows (Qt)
- 🍎 macOS (Qt)

---

# 🚀 Goal

The goal of Happy Frontend is to provide a **simple, fast, and modern interface** to:

- Organize ROM libraries from multiple consoles
- Launch games with a single click
- Integrate multiple emulators in one place
- Centralize retro gaming into a unified system

---

# 🧱 Architecture

---

# 🎮 Supported Systems

- 🕹️ NES
- 🕹️ SNES
- 🕹️ Game Boy / GBA
- 🕹️ PlayStation 1 (PS1)
- 🕹️ PlayStation 2 (PS2)
- 🕹️ Arcade (via RetroArch cores)

---

# ⚙️ How It Works

1. The frontend reads a `games.json` database
2. Displays a clean game library UI
3. User selects a game
4. The system launches the correct emulator:
   - RetroArch (SNES, NES, PS1, etc.)
   - PCSX2 (PS2)
5. The game starts automatically

---

# 📄 Example Game Entry (games.json)

```json
{
  "title": "Super Mario World",
  "system": "SNES",
  "rom": "roms/snes/mario.sfc",
  "core": "snes9x",
  "emulator": "retroarch"
}
