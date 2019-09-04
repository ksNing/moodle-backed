package com.example.moodlebacked.controller;

import com.example.moodlebacked.StudentEnum;
import com.example.moodlebacked.dao.StudentRepository;
import com.example.moodlebacked.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;


@Controller
@ResponseBody
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    /**
     * 学生注册
     * @param xuehao
     * @param major
     * @param name
     * @param passWord
     * @return
     */
    @GetMapping(value = "/register")
    public String register(@RequestParam("xuehao") String xuehao,
                           @RequestParam("major") String major,
                           @RequestParam("name") String name,
                           @RequestParam("passWord") String passWord) {
        Student s = studentRepository.findByXuehao(xuehao);
        if(s != null) {
            return StudentEnum.has_register.getMsg();

        }
        Student student = new Student();
        student.setMajor(major);
        student.setName(name);
        student.setPassWord(passWord);
        student.setXuehao(xuehao);
        studentRepository.save(student);
        return StudentEnum.register_success.getMsg();
    }

    /**
     * 找回密码
     * @param xuehao
     * @param passWord
     * @return
     */
    @GetMapping(value = "/modifyPassword")
    public  HashMap<String, String> modify(@RequestParam("xuehao") String xuehao,
                           @RequestParam("passWord") String passWord) {
        HashMap<String, String> map = new HashMap<>();
        Student s = studentRepository.findByXuehao(xuehao);
        if(s == null) {
            map.put("msg",StudentEnum.not_exist.getMsg());
        } else {
            s.setXuehao(xuehao);
            s.setPassWord(passWord);
            studentRepository.save(s);
            map.put("msg","密码修改成功");
        }
        return map;

    }

    /**
     * 学生登录
     * @param xuehao
     * @param passWord
     * @return
     */
    @RequestMapping(value = "/login")
    public HashMap<String,String> login(@RequestParam("xuehao") String xuehao,
                         @RequestParam("passWord") String passWord) {
        HashMap<String,String> map = new HashMap<>();
        Student s = studentRepository.findByXuehao(xuehao);
        if(s == null) {
            map.put("msg","学生学号或密码错误");
        }
        if(!passWord.equals(s.getPassWord())) {
            map.put("msg","学生学号或密码错误");
        } else {
            map.put("msg","登录成功");
            map.put("name",s.getName());
        }
        return map;
    }


}
