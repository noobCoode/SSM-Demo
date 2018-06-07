package Controllers;

import Entity.Student;
import Service.IStudentService;
import Util.ResultPackage;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
    @ResponseBody
    public ResultPackage insertStudent(@RequestBody JSONObject request) {
        Student student = new Student();
        JSONObject res=new JSONObject();
        try{
            student.setUid(request.getLong("uid"));
            student.setClassid(request.getInteger("classid"));
            student.setName(request.getString("name"));
            student.setAge(request.getInteger("age"));
            studentService.insert(student);
            return ResultPackage.generateResult(0,"",res);
        }catch (DuplicateKeyException de){
            return ResultPackage.generateResult(-1,"主键重复",res);
        }catch (NullPointerException ne){
           return ResultPackage.generateResult(-2,"空指针异常",res);
        }
    }

    @DeleteMapping()
    @ResponseBody
    public ResultPackage deleteStudentByPrimaryKey(@RequestBody JSONObject request){
        JSONObject res=new JSONObject();
        try{
            long uid=request.getLong("uid");
            studentService.deleteByPrimaryKey(uid);
            return ResultPackage.generateResult(0,"",res);
        }catch (Exception e){
            return ResultPackage.generateResult(-3,"未知",res);
        }

    }

    @PutMapping()
    @ResponseBody
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
