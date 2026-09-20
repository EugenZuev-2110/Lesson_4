package Student;

import java.util.ArrayList;
import java.util.List;

public class TestStudent{
    public static void main(String[] args) {
        List<String> mutableList = new ArrayList<>();
        mutableList.add("Java SE");
        mutableList.add("Spring Boot");
        var student = new Student("Алексей", mutableList);
        mutableList.add("Python");
        System.out.println("Количество курсов внутри студента: " + student.getCourses().size());
        try {
            student.getCourses().add("C++");
        } catch (UnsupportedOperationException e) {
            System.out.println("Успех: Выброшено исключение! Список внутри студента защищен от изменений.");
        }
    }
}