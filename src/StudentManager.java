import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentManager {
    // key存储学号,value存储学生信息
    Map<Integer, Student> map = null;

    public StudentManager() {
        map = new HashMap<>();
    }

    /**
     * 添加保存一个学生对象
     * @param student 需要添加的学生对象
     * @return 	false	已经存在
     * @return  true	添加成功
     */
    public boolean add(Student student) {
        Integer id = student.getId();
        if (map.containsKey(id)) {
            return false;// 已经存在
        } else {
            map.put(id, student);
            return true;
        }
    }

    /**
     * 删除一个学生对象
     * @param id	要删除学生学习的id
     * @return		删除成功返回删除的对象
     * 				删除失败返回null
     */
    public Student remove(Integer id) {
        return map.remove(id);
    }

    /**
     * 删除一个学生对象
     * @param student	要删除学生对象
     * @return			删除成功返回删除的对象
     * 					删除失败返回null
     */
    public Student remove(Student student) {
        return map.remove(student.getId());
    }

    /**
     * 修改学生信息,如若修改id,推荐使用此方法
     * @param id		原学生对象的id信息
     * @param student 	修改后的学生对象信息
     */
    public void update(Integer id, Student student) {
        // 删除原ID对象
        map.remove(id);
        // 放入新对象信息
        map.put(student.getId(), student);
    }

    /**
     * 修改学生信息,不修改id得情况下使用此方法
     * @param student 	修改后的学生对象信息
     */
    public void update(Student student) {
        map.put(student.getId(), student);
    }

    /**
     * 查找一条学生信息
     * @param id	要查询学生对象的id
     * @return		查询到的学生对象,无此对象返回null
     */
    public Student query(Integer id) {
        if (map.containsKey(id)) {
            return map.get(id);
        } else {
            return null;
        }
    }

    /**
     * 得到保存的所有信息
     * @return	一个存有所有信息list
     */
    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();

        Set<Integer> set = map.keySet();

        for (Integer integer : set) {
            list.add(map.get(integer));
        }
        return list;
    }
}