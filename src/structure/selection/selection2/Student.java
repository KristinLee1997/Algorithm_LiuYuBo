package structure.selection.selection2;

/**
 * @author LiHang
 * School: 哈尔滨理工大学
 * Saying: Never give up !!!
 * Date:   2017/11/28 20:31
 * Goal:
 **/
public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student student) {
        if (this.score < student.score) {
            return -1;
        } else if (this.score > student.score) {
            return 1;
        } else {
            return this.name.compareTo(student.name);
        }
    }

    @Override
    public String toString() {
        return "Student:" + this.name + Integer.toString(this.score);
    }


}
