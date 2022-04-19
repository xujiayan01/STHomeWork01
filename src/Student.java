/**
 * 描述:
 * @date    2018年8月16日    下午6:59:03
 * @version v1.0
 */
public class Student implements Comparable<Student> {
    /**
     * @ 学生信息类
     *
     */
    private Integer id; // ID学号
    private String name; // 姓名
    private String sex; // 性别
    private Integer age; // 年龄

    // 不允许创建空对象
    // public Customer() {
    // }

    // 允许地址、联系方式为空构建对象
    public Student(Integer id, String name, String sex, int age) {
        super();

        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return String.format("学号:%s姓名:%s,性别:%s,年龄:%d", id, name, sex, age
                );
    }

    @Override
    public int compareTo(Student student) {
        int l = this.id - student.id;
        return l == 0 ? this.name.compareTo(student.name) : l;
    }

}