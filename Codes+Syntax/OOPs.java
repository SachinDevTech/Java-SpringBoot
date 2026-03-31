public class OOPs{
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.age = 21;
        s1.className = "XII";
        s1.rollnum = 7609;
        s1.schoolName = "GDPS, Shikohabad";

        s1.printDetails();
    }    
}

class Student{
    String name;
    int age;
    int rollnum;
    char section;
    String className;
    String schoolName;
    
    public void printDetails(){
        System.out.println(this.name + this.age + this.rollnum + this.section + this.className + this.schoolName);
    }

    public void setValues(String name, int age, int rollnum, char section){
        name = this.name;
        age = this.age;
        rollnum = this.age;
        section = this.section;
    }
}