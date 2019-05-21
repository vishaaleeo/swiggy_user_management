package swiggy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import swiggy.domain.Response;
import swiggy.domain.User;
import swiggy.services.UserDAOImplementaion;


/*
 *To control and regulate the paths
 */
@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    UserDAOImplementaion userDAOImplementaion;



    @GetMapping("/signup")
    public ModelAndView getSignup() {
        return new ModelAndView("signup");
    }
    
    @RequestMapping("/signup")
    @SendTo("/topic/user")
    public ResponseEntity createUser(@RequestBody User user) {

        String result=userDAOImplementaion.createUser(user);
        if(result.equals("success")) {

            return new ResponseEntity("User created successfully",HttpStatus.valueOf(201));
        }

        else {
            return new ResponseEntity(result,HttpStatus.valueOf(400));
        }
    }


    @MessageMapping("/user")
    @SendTo("/topic/user")
    public Response login(User user) {

        System.out.println(user.toString());
        User loginUser = userDAOImplementaion.loginUser(user);
        if(loginUser!=null) {
            //return new ResponseEntity<String>(loginUser.toString(), HttpStatus.valueOf(200));
            System.out.println(loginUser.toString());
            return new Response(loginUser.toString());
        }
        else {
            return new Response("invalid user login");
            //return new ResponseEntity<>("invalid user login",HttpStatus.valueOf(200));
        }
    }

    @PostMapping ("/update")
    public ResponseEntity updateUser(@RequestBody User user) {

    String result=userDAOImplementaion.updateUser(user);
    return new ResponseEntity(result,HttpStatus.valueOf(200));
    }




    @PostMapping("/delete")
    public ResponseEntity deleteUser(@RequestBody User user) {

       String result= userDAOImplementaion.deleteUser(user);

       return new ResponseEntity(result,HttpStatus.valueOf(200));
    }



}
