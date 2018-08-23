package assignment1.question3;

import java.util.*;

public class EmployeeDataOperations implements DataService<Employee , Integer> {
    Map<Integer,Employee> hm = new HashMap<Integer, Employee>();

    private static EmployeeDataOperations singletonObject = new EmployeeDataOperations();

    private EmployeeDataOperations(){}

    public boolean add(Employee emp) {
        if(!hm.containsKey(emp.getId())){
            hm.put(emp.getId(), emp);
            return true ;
        }
        return false;
    }

    public boolean remove(int id){
        if(hm.containsKey(id)){
            hm.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Employee findById(Integer id) {
        if(hm.containsKey(id)){
            return hm.get(id) ;
        }
        return null;
    }

    @Override
    public int getCount() {
        return hm.size() ;
    }

    @Override
    public List<Employee> findAll(Map<Integer,Employee> m) {
        List<Employee> listEmployee = new ArrayList();
        for(Employee emp:m.values()){
            listEmployee.add((emp));
        }
        return listEmployee ;
    }

    @Override
    public void deleteAll() {
        hm.clear();
    }

    @Override
    public boolean removeById(Integer id) {
        if(hm.containsKey(id)){
            hm.remove(id) ;
            return true ;
        }
        return false;
    }

    public static EmployeeDataOperations getInstance(){
        return singletonObject;
    }
}
