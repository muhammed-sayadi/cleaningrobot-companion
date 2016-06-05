package com.cleaningrobot.controller;

import com.cleaningrobot.dao.service.ReportService;
import com.cleaningrobot.dao.service.RobotService;
import com.cleaningrobot.dao.service.TaskService;
import com.cleaningrobot.dao.service.UserService;
import com.cleaningrobot.model.Report;
import com.cleaningrobot.model.Robot;
import com.cleaningrobot.model.Task;
import com.cleaningrobot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AppController
{
    private static UserService userService = new UserService();
    private static User currentUser = new User();

    private static RobotService robotService = new RobotService();
    private static Robot currentRobot = new Robot();

    private static ReportService reportService = new ReportService();
    private static List<Report> currentReports;

    private static TaskService taskService = new TaskService();
    private static List<Task> currentTasks;


    /*
    ********** Authentication Controller *********************
     */

    @RequestMapping(value = "/app/signup", method = RequestMethod.GET)
    public String newUser(final User user, ModelMap modelMap)
    {
        return "/app/signup";

    } // end method newUser

    @RequestMapping(value = "/app/signup", method = RequestMethod.POST)
    public String createUser(User user, BindingResult bindingResult, Model mode)
    {
        userService.create(user);
        return "/app/login";

    } // end method createUser

    @RequestMapping(value = "/app/login", method = RequestMethod.GET)
    public String loadLogin(final User user, ModelMap modelMap)
    {
        return "/app/login";

    } // end method loadLogin

    @RequestMapping(value = "/app/index", method = RequestMethod.POST)
    public String login(final User user,
                        BindingResult bindingResult,
                        ModelMap modelMap)
    {

        currentUser = userService.retrieveByEmail(user.getEmail());
        modelMap.put("user", currentUser);
        for(User indexUser: userService.retrieveAll())
        {
            if(user.getEmail().equals(indexUser.getEmail()) &&
                    user.getPassword().equals(indexUser.getPassword()))
                return "/app/index";
        }

        return "/app/login";

    } // end method login

    /*
    ****************** User Controller *************************
     */

    @RequestMapping(value = "/app/user", method = RequestMethod.GET)
    public String userDetails(final User user, ModelMap modelMap)
    {
        modelMap.put("user", currentUser);
        return "/app/user";

    } // end method userDetails

    @RequestMapping(value = "/app/user", method = RequestMethod.POST)
    public String updateUser(final User user, ModelMap modelMap)
    {
        user.setId(currentUser.getId());
        userService.update(user);
        modelMap.put("user", user);
        currentUser = user;
        return "/app/user";

    } // end method updateUser

    /*
    ************** Robot Controller ***************************
        */

    @RequestMapping(value = "/app/robot-status", method = RequestMethod.GET)
    public String displayRobotStatus(ModelMap modelMap)
    {
        currentRobot = robotService.retrieveByUserId(currentUser.getId());
        modelMap.put("robot", currentRobot);
        modelMap.put("user", currentUser);
        return "/app/robot-status";

    } // end method displayRobotStatus

    @RequestMapping(value = "/app/robot-info", method = RequestMethod.GET)
    public String displayRobotInfo(ModelMap modelMap)
    {
        currentRobot = robotService.retrieveByUserId(currentUser.getId());
        modelMap.put("robot", currentRobot);
        modelMap.put("user", currentUser);
        return "/app/robot-info";

    } // end method displayRobotInfo

    @RequestMapping(value = "/app/robot-info", method = RequestMethod.POST)
    public String changeRobotNickname(ModelMap modelMap,
                                      Robot robot)
    {
        currentRobot.setNickname(robot.getNickname());
        robotService.update(currentRobot);
        modelMap.put("user", currentUser);
        modelMap.put("robot", currentRobot);
        return("/app/robot-info");

    } // end method changeRobotNickname

    /*
    ************** Reports Controller ******************
     */

    @RequestMapping(value = "/app/reports", method = RequestMethod.GET)
    public String displayReports(ModelMap modelMap)
    {
        currentRobot = robotService.retrieveByUserId(currentUser.getId());
        currentReports = reportService.retrieveAllByRobotSn(currentRobot.getSn());

        modelMap.put("user", currentUser);
        modelMap.put("robot", currentRobot);
        modelMap.put("reports", currentReports);

        return("/app/reports");

    } // end method displayReports

    /*
    ***************** Tasks Controller *********************
     */

    @RequestMapping(value = "/app/tasks", method = RequestMethod.GET)
    public String displayTasks(ModelMap modelMap)
    {
        currentRobot = robotService.retrieveByUserId(currentUser.getId());

        currentTasks = taskService.retrieveAllByRobotSn(currentRobot.getSn());

        Task emptyTask = currentTasks.get(0);
        modelMap.put("task", emptyTask);
        modelMap.put("user", currentUser);
        modelMap.put("robot", currentRobot);
        modelMap.put("tasks", currentTasks);

        return("/app/tasks");

    } // end method displayTasks

    @RequestMapping(value = "/app/tasks", method = RequestMethod.POST)
    public String schduleATask(Task task, BindingResult bindingResult, ModelMap modelMap)
    {
        task.setRobotSn(currentRobot.getSn());
        taskService.create(task);
        currentTasks = taskService.retrieveAllByRobotSn(currentRobot.getSn());
        modelMap.put("user", currentUser);
        modelMap.put("tasks", currentTasks);
        Task emptyTask = currentTasks.get(0);
        modelMap.put("task", emptyTask);

        return "/app/tasks";

    } // end method schduleATask

    /*
    *********************** Settings ***************************
     */

    @RequestMapping(value = "/app/settings", method = RequestMethod.GET)
    public String loadSettings(ModelMap modelMap)
    {
        modelMap.put("user", currentUser);
        return "/app/settings";

    } // end method loadSettings

} // end class AppController
