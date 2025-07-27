import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
public class TaskManagerGUI {
    TaskManager taskManager = new TaskManager();
    TaskManagerGUI(){
        
        JFrame jf = new JFrame("Task Manager Interface");
        //sets frame size
        jf.setSize(600,600);

        //kills when users closes window
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font uiFont = new Font("Segoe UI", Font.PLAIN, 14);

        //textbased label
        //JLabel jl = new JLabel("Task Manager UI");
        JLabel jlds = new JLabel("Delete by ID");
        JLabel jlc = new JLabel("Complete by ID");
        JButton jb1 = new JButton("Add Task");
        JTextField idField = new JTextField(15);
        JButton jbc = new JButton("Mark Complete");
        
        //IO Button and shii
        JButton jbs = new JButton("Save to File");
        JButton jbl = new JButton("Load from File");
        
        JTextField idDeleteField = new JTextField(15);
        JButton jbd = new JButton("Delete Task");

        JTextArea jt = new JTextArea(10,20);
        jt.setEditable(false);


        JScrollPane jsp = new JScrollPane(jt);
        JPanel tPanel = new JPanel(new GridLayout());
        JPanel dPanel = new JPanel(new GridLayout());
        JPanel addPanel = new JPanel(new GridLayout());
        JPanel cPanel = new JPanel(new GridLayout());
        //JPanel comPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel dePanel = new JPanel(new GridLayout());
        JLabel jlt = new JLabel("Title");
        JTextField titleField = new JTextField(15);

        JLabel jld = new JLabel("Description");
        JTextField descField = new JTextField(15);

        //Search Stuff
        JLabel search = new JLabel("Search keyword");
        JTextField searchField = new JTextField(15);
        JButton jSearch = new JButton("Search");
    
        //add label to main window
        //jf.add(jl);
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String title = titleField.getText();
                String description = descField.getText();
                if (title.isEmpty() || description.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please fill in both title and description.");
    return;
}
                taskManager.addTask(title, description);
                JOptionPane.showMessageDialog(null, "Task added!");

                jt.setText("");
                for(Task t :taskManager.task){
                    System.out.println(t.toString());
                    jt.append(t.toString()+"\n");
                }
                titleField.setText("");
                descField.setText("");
            }
        });

        jbc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String id = idField.getText();
                int intId;
                try {
                    intId = Integer.parseInt(id);
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Invalid ID. Please enter a number.");
                    return;}

                taskManager.markTaskComplete(intId);
                JOptionPane.showMessageDialog(null, "Task marked as complete!");

                jt.setText("");
                for(Task t : taskManager.task){
                    jt.append(t.toString()+"\n");
                }
                idField.setText("");
            }
        });

        jbd.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
            String iddel = idDeleteField.getText();
            int id_del;
            try{
                id_del = Integer.parseInt(iddel);
            } 
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Invalid ID. Please enter a number.");
                    return;
            }
            taskManager.deleteTask(id_del);
            JOptionPane.showMessageDialog(null, "Task deleted!");

            jt.setText("");
            for(Task t : taskManager.task){
                jt.append(t.toString()+"\n");
            }
            idDeleteField.setText("");
           } 
        });
         jbs.addActionListener(e->{
            taskManager.SaveTask();
            JOptionPane.showMessageDialog(null, "Tasks saved!");
        });
        jbl.addActionListener(e->{
            jt.setText("");
            taskManager.LoadTask();
            jt.setText("");
            for(Task t: taskManager.task){
                jt.append(t.toString()+"\n");
            }
            JOptionPane.showMessageDialog( null, "Task Loaded");
        });
        jSearch.addActionListener(e->{
            String keyword = searchField.getText();
            ArrayList<Task> results = taskManager.searchTasks(keyword);
            jt.setText("");
            if(results.isEmpty()){
                jt.append("No matching tasks found.\n");
            } else{
                for (Task t: results){
                    jt.append(t.toString()+"\n");
                }
                searchField.setText("");
            }
        });
        JPanel searchPanel = new JPanel();
        //Panel attempt
        JPanel jio = new JPanel();
        jio.add(jbs);
        jio.add(jbl);
        JPanel jp = new JPanel();
        new BoxLayout(jp, BoxLayout.Y_AXIS);
        //jp.add(jb1);
        //jp.add(jb2);
        jlds.setFont(uiFont);
        jlc.setFont(uiFont);
        jlt.setFont(uiFont);
        jld.setFont(uiFont);
        titleField.setFont(uiFont);
        descField.setFont(uiFont);
        jb1.setFont(uiFont);
        tPanel.setBorder(BorderFactory.createTitledBorder("Task Title"));
dPanel.setBorder(BorderFactory.createTitledBorder("Task Description"));
cPanel.setBorder(BorderFactory.createTitledBorder("Mark Complete"));
dePanel.setBorder(BorderFactory.createTitledBorder("Delete Task"));
jio.setBorder(BorderFactory.createTitledBorder("Save / Load"));

        addPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        tPanel.add(jlt);
        tPanel.add(titleField);

        
        dPanel.add(jld);
        dPanel.add(descField);
        
        cPanel.add(jlc);
        cPanel.add(idField);
        //comPanel.add(jbc);
        cPanel.add(jbc);
        
        addPanel.add(jb1);
       
        dePanel.add(jlds);
        dePanel.add(idDeleteField);
        dePanel.add(jbd);
        
        searchPanel.add(search);
        searchPanel.add(searchField);
        searchPanel.add(jSearch);
       /* jp.add(jsp);
        jp.add(jl);
        jp.add(jlt);
        jp.add(titleField);
        jp.add(jld);
        jp.add(descField); */
        jp.add(tPanel);
        jp.add(dPanel);
        jp.add(addPanel);
        jp.add(cPanel);
        
        //jp.add(comPanel);
        jp.add(dePanel);
        jp.add(jio);
        jp.add(jsp);
        jp.add(searchPanel);
        jp.setBackground(Color.CYAN);
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jf.add(jp);
        //displays the frame
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        //Create the frame on the event dispatching thread
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e){
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable(){
         public void run(){
            new TaskManagerGUI();
         }   
        });
    }
}
