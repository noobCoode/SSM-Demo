package Controllers;

import Entity.Student;
import Service.IStudentService;
import Util.ResultSetUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
    public JSONArray getStudent() {
        List<Student> students = studentService.selectByCondition(new Student());
        return JSONArray.parseArray(JSON.toJSONString(students));
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

    @DeleteMapping()
    @ResponseBody
    public JSONObject deleteStudentByPrimaryKey(@RequestBody JSONObject request){
        try{
            long uid=request.getLong("uid");
            studentService.deleteByPrimaryKey(uid);
            return ResultSetUtil.result("success");
        }catch (Exception e){
            return ResultSetUtil.result("fail");
        }

    }

    @PutMapping()
    public String updateStudnetByPrimaryKey(@RequestBody JSONObject request){
        Student student=new Student();
        student.setUid(request.getLong("uid"));
        student.setClassid(request.getInteger("classid"));
        student.setName(request.getString("name"));
        student.setAge(request.getInteger("age"));
        studentService.updateByPrimaryKey(student);
        return "success";
    }



}
