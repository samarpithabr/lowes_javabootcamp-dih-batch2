package com.examples.empapp.controller;


@Controller
public class RegistrationController {
  @Autowired
  public UserService userService;

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());

    return mav;
  }

  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("user") User user) {

    userService.register(user);

    return new ModelAndView("home", "firstname", user.getFirstname());
  }
}