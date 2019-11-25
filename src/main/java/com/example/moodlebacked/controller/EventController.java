package com.example.moodlebacked.controller;

import com.example.moodlebacked.dao.EventBeanRepository;
import com.example.moodlebacked.entity.EventBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/student")
public class EventController {
    @Autowired
    private EventBeanRepository eventBeanRepository;



    @RequestMapping("/main")
    public String main() {
        return "hello moodle";
    }

    /**
     * 点击事件的发生
     * @param xuehao
     * @param name
     * @param eventName
     * @param systemVersion
     * @param timeStamp
     * @param devicesModel
     * @return
     */
    @RequestMapping("/event")
    public String startCount(@RequestParam("xuehao") String xuehao,
                           @RequestParam("name") String name,
                           @RequestParam("eventName") String eventName,
                           @RequestParam("systemVersion") String systemVersion,
                           @RequestParam("timeStamp") String timeStamp,
                           @RequestParam("devicesModel") String devicesModel) {
        EventBean eventBean = new EventBean();
        eventBean.setDevicesModel(devicesModel);
        eventBean.setEventName(eventName);
        eventBean.setName(name);
        eventBean.setTimeStamp(timeStamp);
        eventBean.setSystemVersion(systemVersion);
        eventBean.setXuehao(xuehao);
        eventBeanRepository.save(eventBean);
        return "success";

    }


}
