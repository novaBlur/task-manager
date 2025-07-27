import java.util.ArrayList;
import java.io.*;
public class TaskManager {
    ArrayList<Task> task = new ArrayList<Task>();
        int nextid = 1;
    void addTask(String title, String description){
        Task t = new Task(nextid++,title,description);
        task.add(t);
    }
    
    void listTasks(){
         if(task.isEmpty()){
                System.out.println("No tasks just yet");
            }
            else{
        for(Task t : task){
            System.out.println(t);
        }
    }
    }
    
    void deleteTask(int idtoFind){
        for(int i = 0; i<task.size();i++){
            if(task.get(i).id == idtoFind){
                task.remove(i);
                break;
            }
        }
    }

    void markTaskComplete(int id){
        for(Task t: task){
            if(t.id == id){
                t.markComplete();
                System.out.println(t.toString());
                return;
            }
        }

    }
    void SaveTask(){
        try{
        BufferedWriter writer = new BufferedWriter(new FileWriter("tasks.txt"));
        for(Task t: task){
            String line = t.id + "|" + t.title + "|" + t.description + "|" + t.completed;
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    } catch(IOException e){
        e.printStackTrace();}
    }
    void LoadTask(){
    try{
        BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"));
        String line;

        task.clear();              // 💥 Clear the current list
        nextid = 1;                // ✅ Reset the ID counter

        while((line = reader.readLine()) != null){
            String[] parts = line.split("\\|");
            int id = Integer.parseInt(parts[0]);
            String title = parts[1];
            String description = parts[2];
            boolean completed = Boolean.parseBoolean(parts[3]);

            Task t = new Task(id, title, description);
            if(completed){
                t.markComplete();
            }

            task.add(t);

            // 🔁 Ensure nextid is always ahead of the highest existing ID
            if (id >= nextid) {
                nextid = id + 1;
            }
        }
        reader.close();
    } catch(IOException e){
        e.printStackTrace();
    }
}

ArrayList<Task> searchTasks(String keyword){
    ArrayList<Task> matches = new ArrayList<Task>();
    for(Task t : task){
        if(t.title.toLowerCase().contains(keyword.toLowerCase())|| t.description.toLowerCase().contains(keyword.toLowerCase())){
            matches.add(t);
        }
    }
    return matches;

}

}
