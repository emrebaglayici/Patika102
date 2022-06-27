package Collactions.HackerRankPriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Priorities {
    private final PriorityQueue<Student> priorityQueue
            =new PriorityQueue<>(
            Comparator.comparing(Student::getCgpa).reversed()
                    .thenComparing(Student::getName)
                    .thenComparing(Student::getId)
    );
    public List<Student> getStudents
            (List<String> events) {
          for(String event:events){
              if(event.equals("SERVED")){
                  priorityQueue.poll();
              }else{
                  String[] detail=event.split(" ");
                  String name=detail[1];
                  double cgpa= Double.parseDouble(detail[2]);
                  int id= Integer.parseInt(detail[3]);
                  Student student=new Student(
                          id,name,cgpa
                  );
                  priorityQueue.add(student);

//                  priorityQueue.add(new Student(
//
//                          Integer.parseInt(detail[3]),detail[1],
//                          Double.parseDouble(detail[2])
//                  ));
              }
          }
          List<Student> students=new ArrayList<>();
          while (!priorityQueue.isEmpty()){
              students.add(priorityQueue.poll());
          }
          return students;
    }
}
