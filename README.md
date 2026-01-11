# 💻 Computer Application Manager (Java)

A simple **Java desktop application** that simulates managing computer applications, including games, social apps, and utility apps.

The project demonstrates **OOP concepts**, **inheritance**, **serialization**, and **basic data persistence** using Java.

---

## ✨ Features

- User login system
- App installation and uninstallation
- Multiple app types:
  - Game applications
  - Social applications
  - Utility applications
- App information display
- Persistent data storage using serialization (`.ser` files)

---

## 🧱 Project Structure

```
ComputerSim/
├── .idea/
├── out/
├── src/
│ ├── Controller/
│ │ ├── Apps/
│ │ │ ├── AppFactory.java
│ │ │ └── Apps.java
│ │ └── Data/
│ │ └── DataHandler.java
│ │
│ ├── Models/
│ │ ├── ComputerApp.java
│ │ ├── GameApp.java
│ │ ├── SocialApp.java
│ │ ├── UtilityApp.java
│ │ └── UserProfile.java
│ │
│ ├── View/
│ │ ├── Menus/
│ │ │ ├── LoginMenuGUI.java
│ │ │ └── MainMenuGUI.java
│ │ └── SideMenu/
│ │ ├── DisplayInstalledAppsGUI.java
│ │ ├── InstallAppMenuGUI.java
│ │ ├── LoginAndRegister.java
│ │ └── UninstallAppMenuGUI.java
│ │
│ └── Main.java
│
├── apps.ser
└── userdata.ser
```


---

## 🧠 Architecture Overview

- **Models**  
  Core data classes representing applications and users.

- **Controller**
  - `Apps` → application management logic  
  - `AppFactory` → app object creation  
  - `DataHandler` → serialization & persistence

- **View**
  - `Menus` → login & main menu UI  
  - `SideMenu` → install, uninstall, and app display UI

- **Persistence**
  - `apps.ser` → stored application data
  - `userdata.ser` → stored user credentials

### Application Model System

- `ComputerApp` is the base class
- Specialized apps extend it:
  - `GameApp`
  - `SocialApp`
  - `UtilityApp`
- Each app stores:
  - Name
  - Size
  - Installation status
  - Type-specific data

---

### 2️⃣ User System

- User credentials are stored in `UserProfile`
- Supports:
  - User registration
  - Login validation
- Credentials are saved locally using serialization

---

### 3️⃣ Data Persistence

- Uses Java **Object Serialization**
- Saved files:
  - `userdata.ser` → user accounts
  - `apps.ser` → installed applications
- Data is automatically loaded on program startup

---

## 🚀 How to Run

1. Open the project in an IDE (IntelliJ IDEA recommended)
2. Run `Main.java`
3. Log in or create a new user
4. Manage applications via the GUI

---

## 🛠️ Technical Details

- Language: **Java**
- Paradigm: **Object-Oriented Programming**
- Data Storage: **Serialization (`ObjectInputStream / ObjectOutputStream`)**
- UI: **Java GUI (Swing/AWT based)**

---

## 📌 Learning Objectives

This project demonstrates:

- Inheritance and polymorphism
- Encapsulation and abstraction
- Java serialization
- Basic MVC-style separation
- GUI-driven application flow

---

## 📜 License

This project is intended for **educational purposes**.  
Feel free to modify or extend it for learning and practice.
