package assignment1.question3;

public class Employee {
    private int id ;
    private String name ;
    private int salary ;

    Employee(int id, String name, int salary){
        this.id = id ;
        this.name = name;
        this.salary = salary ;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return (int) salary;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        final Employee other = (Employee) obj;
//        if (id==0) {
//            if (other.id != 0)
//                return false;
//        } else if (!id.equals(other.id))
//            return false;
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        return this.id ;
//    }
}