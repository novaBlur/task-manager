public class Task {
int id;
String title;
String description;
boolean completed = false;

Task (int id, String title, String description){
    this.id = id;
    this.title = title;
    this.description = description;
    this.completed = false;
}

void markComplete(){    
    this.completed = true;
}

@Override
public String toString() {
    return (completed ? "[✔]" : "[ ]") +
           " ID: " + id +
           " | Title: " + title +
           " | Description: " + description;
}


}
