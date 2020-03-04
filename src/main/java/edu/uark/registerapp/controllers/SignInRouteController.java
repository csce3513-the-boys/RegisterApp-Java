package edu.uark.registerapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.employees.helpers.ActiveEmployeeExistsQuery;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.EmployeeSignIn;

import java.util.Map;

import edu.uark.registerapp.controllers.enums.ViewModelNames;

import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping(value = "/signIn")
public class SignInRouteController extends BaseRouteController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(@RequestParam Map<String,String> queryParams,  HttpServletRequest request) {
		if(activeEmployeeExistsQuery.exists()){
			
		}
	}
	// TODO: Route for initial page load

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView performSignIn(EmployeeSignIn employeeSignIn,
		// TODO: Define an object that will represent the sign in request and add it as a parameter here
		HttpServletRequest request
	) {
		// TODO: Use the credentials provided in the request body
		//  and the "id" property of the (HttpServletRequest)request.getSession() variable
		//  to sign in the user

		return new ModelAndView(
			REDIRECT_PREPEND.concat(
				ViewNames.MAIN_MENU.getRoute()));
	}
	@Autowired
	private ActiveEmployeeExistsQuery activeEmployeeExistsQuery;
	@Autowired
	private EmployeeSignInCommand employeeSignInCommand;
}
