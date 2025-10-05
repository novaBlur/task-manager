Task Manager (Console & Swing GUI)
A simple Java Task Manager implemented in two variations:
- Console app (menu-driven)
- Swing GUI

Both versions share the same core logic so you don’t duplicate code.

Features
- Add, delete, list, and mark tasks complete
- Persist tasks to `tasks.txt`
- Search/filter tasks
- Simple, dependency-free Java (no frameworks)

Project Structure
Task.java // Model: represents a single task
TaskManager.java // Core logic: add/remove/save/load/search
TaskManagerMain.java // Console entry point
TaskManagerGUI.java // Swing GUI entry point
tasks.txt // Data file (created at runtime)

How to Run
# Console Version
javac Task.java TaskManager.java TaskManagerMain.java
java TaskManagerMain

# GUI Version
javac Task.java TaskManager.java TaskManagerGUI.java
java TaskManagerGUI

(If you prefer, compile everything at once: javac *.java.)
