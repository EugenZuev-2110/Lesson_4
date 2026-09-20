package Student;

import java.util.ArrayList;
import java.util.List;

public final class Student {

    private final String name;
    private final List<String> courses;

    public Student(String name, List<String> courses) {
        this.name = name;

        if (courses != null) {
            this.courses = List.copyOf(courses);
        } else {
            this.courses = List.of();
        }
    }
    
    public String getName() {
        return name;
    }

    public List<String> getCourses() {
        return courses;
    }
}