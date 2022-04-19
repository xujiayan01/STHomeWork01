import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner input;
    private StudentManager cc;

    private static final View view = new View();

    private View() {
        input = new Scanner(System.in);
        cc = new StudentManager();
    }

    public static View getInstance() {
        return view;
    }

    /**
     * 系统初始化,让系统运行前就有一部分数据,方便测试用.
     */
    public void APP() {

    }

    /**
     * 启动系统
     */
    public void run() {

        boolean flag = true;
        exit: while (flag) {
            menu();
            int i = input.nextInt();
            input.nextLine();

            switch (i) {
                case 1:
                    addAcc();
                    break;
                case 2:
                    delAcc();
                    break;
                case 3:
                    reviseAcc();
                    break;
                case 4:
                    quaryAcc();
                    break;
                case 5:
                    showAll();
                    break;
                case 6:
                    break exit;
                default:
                    break;
            }
        } // while
        input.close();
        System.out.println("系统退出");
    }// run

    /**
     * 显示菜单界面
     */
    public void menu() {
        System.out.println("请选择操作：");
        System.out.println("************************");
        System.out.println(" 1. 插入");
        System.out.println(" 2. 删除");
        System.out.println(" 3. 修改");
        System.out.println(" 4. 查找");
        System.out.println(" 5. 输出");
        System.out.println(" 6. 退出");
        System.out.println("************************");
        System.out.print(" 请选择1~6: ");
    }

    /**
     * 构建一个完整学生对象
     * @param student 需要添加数据的学生对象
     * @param flag	  需要添加的数据
     */
    public void newAcc(Student student, int flag) {
        String string = "";
        boolean ok = false;
        do {
            if (flag == 0 || flag == 1) {
                System.out.print("\t学号: ");
                string = input.nextLine();
                if (string.matches("[\\d]{10}")) {
                    student.setId(Integer.valueOf(string));
                    ok = true;
                } else {
                    System.out.println("error：学号必须为10位数字\n请重新输入：");
                }
            }

            if (flag == 0 || flag == 2) {
                System.out.print("\t姓名: ");
                string = input.nextLine();
                student.setName(string);
                ok = true;
            }

            if (flag == 0 || flag == 3) {
                System.out.print("\t性别: ");
                string = input.nextLine();
                student.setSex(string);
                ok = true;
            }

            if (flag == 0 || flag == 4) {
                System.out.print("\t出生日期: ");

                String ageStr = input.nextLine();

                if (ageStr.matches("[\\d]{1,4}")) {
                    student.setAge(Integer.parseInt(ageStr));
                    ok = true;
                } else {
                    System.out.println("error：年龄必须为1~4位数字\n请重新输入：");
                }
            }

        } while (!ok);
    }

    /**
     * 添加一条学生信息
     */
    public void addAcc() {
        System.out.println("请输入要添加学生的信息:");

        Student student = new Student(151164461, "", "", 0);
        newAcc(student, 0);

        if (cc.add(student)) {
            System.out.println("插入成功!");
            System.out.println(student);
        } else {
            System.out.println("插入失败!");
        }
    }

    /**
     * 删除一条学生信息
     */
    public void delAcc() {
        System.out.print("请输入要删除的学号:");
        String id = input.nextLine();

        Student student = cc.remove(Integer.valueOf(id));

        if (student == null) {
            System.out.println("不存在该联系人!");
        } else {
            System.out.println(student);
            System.out.println("学生删除成功!");
        }
        showAll();
    }

    /**
     * 修改学生信息
     */
    public void reviseAcc() {
        System.out.print("请输入要修改学号:");
        String str = input.nextLine();
        int id = Integer.parseInt(str);

        Student student = cc.query(id);
        if (student == null) {
            System.out.println("不存在该学生~");
            return;
        }
        System.out.println(student);
        boolean flag = true;
        while (flag) {
            System.out.println("=========修改学生信息=========");
            System.out.println(" 1. 修改学号");
            System.out.println(" 2. 修改姓名");
            System.out.println(" 3. 修改性别");
            System.out.println(" 4. 修改年龄");
            System.out.println(" 5. 修改联系方式");
            System.out.println(" 6. 结束修改");
            System.out.println("==========================");
            System.out.print(" 请选择1~6: ");

            int i = Integer.parseInt(input.nextLine());
            if (i == 6) {
                break;
            }
            newAcc(student, i);

        } // while

        cc.update(id, student);
        System.out.println("修改成功！");
        System.out.println(student);

    }

    /**
     * 查看一条学生信息
     */
    public void quaryAcc() {
        System.out.print("请输入要查找学生的学号:");
        String str = input.nextLine();

        Student c1 = cc.query(Integer.parseInt(str));
        if (c1 == null) {
            System.out.println("不存在该学生");
        } else {
            System.out.println(c1);
        }
    }

    /**
     * 显示所有学生信息,默认升序排序
     */
    public void showAll() {
        List<Student> list = cc.getAll();
        Collections.sort(list);
        System.out.println("==========================");
        System.out.println("总共" + list.size() + "条信息:");
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println();
    }
}