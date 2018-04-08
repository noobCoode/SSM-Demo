package Controllers;

import Entity.Student;
import Service.IStudentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping()
    public String get() {
        List<Student> students = studentService.selectByCondition(new Student());
        return com.alibaba.fastjson.JSON.toJSONString(students);
    }

    @PostMapping()
    public String insertStudent(@RequestBody JSONObject request) {
        Student student = new Student();
        student.setName("xudongdong");
        student.setClassid(2);
        student.setAge(20);
        studentService.insert(student);
        return com.alibaba.fastjson.JSON.toJSONString(student);
    }

}
