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
    private IStudentService service;

    @GetMapping("/get")
    public String get() {
        List<Student> students = service.selectByCondition(new Student());
        String jsonResult = com.alibaba.fastjson.JSON.toJSONString(students);
        return jsonResult;
    }
   @PostMapping("/insert")
    public String insertStudent(@RequestBody JSONObject request){
        Student student=new Student();
        student.setName("xudongdong");
        student.setClassid(2);
        student.setAge(20);
        student.setUid(new byte[1]);
        service.insert(student);
        String jsonResult = com.alibaba.fastjson.JSON.toJSONString(student);
        return jsonResult;
    }

}
