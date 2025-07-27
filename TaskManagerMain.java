import java.util.Scanner;

public class TaskManagerMain {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
       Scanner scanner = new Scanner(System.in); 
       while(true){
            System.out.println("\nTask Manager Menu");
            System.out.println("1.Add a new task");
            System.out.println("2.List all tasks");
            System.out.println("3.Mark a task as completed");
            System.out.println("4.Delete a task");
            System.out.println("5. Save your tasks to a .txt file");
            System.out.println("6. Load your tasks from a .txt file to the array");
            System.out.println("7. Search by keyword");
            System.out.println("8. Exit the program");
            System.out.print("Enter your choice(1-7): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: System.out.print("Enter task title: ");
                String title = scanner.nextLine();
                System.out.println("\nEnter task description: ");
                String description = scanner.nextLine();
                taskManager.addTask(title,description);
                    break;
                case 2: taskManager.listTasks();
                    break;
                case 3: System.out.println("Enter id of task you wanna mark as completed");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        taskManager.markTaskComplete(id);
                    break;
                case 4:
                System.out.println("Enter id of task you wanna delete");
                    id = scanner.nextInt();
                        scanner.nextLine();
                        taskManager.deleteTask(id);
                    break;
                case 5:
                System.out.println("Saving tasks to a text file");
                taskManager.SaveTask();
                    break;
                case 6:
                System.out.println("Loading tasks from your text file");
                taskManager.LoadTask();
                break;
                case 7:
                System.out.println("Enter keyword");
                String keyword = scanner.nextLine();
                System.out.println("Searching for keyword");
                taskManager.searchTasks(keyword);
                case 8:
                System.out.println("Exitting the program...");
                scanner.close();
                return;
                default:
                System.out.println("invalid option");
                    break;
            }
            
        }
       
        
    }
    
}
