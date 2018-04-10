package Controllers;

import Entity.Student;
import Service.IStudentService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

@RestController
@RequestMapping(value = "/api/Students", produces = "application/json;charset=UTF-8")
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
        student.setUid(request.getLong("uid"));
        student.setClassid(request.getInteger("classid"));
        student.setName(request.getString("name"));
        student.setAge(request.getInteger("age"));
        studentService.insert(student);
        return JSON.toJSONString(student);
    }

}
