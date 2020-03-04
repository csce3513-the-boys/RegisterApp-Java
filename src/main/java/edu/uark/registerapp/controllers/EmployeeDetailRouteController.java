package edu.uark.registerapp.controllers;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.joran.conditional.ElseAction;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.controllers.enums.QueryParameterMessages;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.controllers.enums.QueryParameterMessages;
import edu.uark.registerapp.controllers.enums.QueryParameterNames;

@Controller
@RequestMapping(value = "/employeeDetail")
public class EmployeeDetailRouteController extends BaseRouteController {
	private Object employeeQuery;
	private Object activeEmployeeExistsQuery;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(
		@RequestParam final Map<String, String> queryParameters,
		final HttpServletRequest request
	) {

		// TODO: Logic to determine if the user associated with the current session
		//  is able to create an employee
		ModelAndView modelandview;

		final Optional<ActiveUserEntity> activeUserEntity = this.getCurrentUser(request);
		boolean elevatedUser = this.isElevatedUser(activeUserEntity.get());

			if(elevatedUser || !activeUserExists())
			{
				modelandview = new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName())
					.addObject(ViewModelNames.EMPLOYEE.getValue(), new Employee());
			}
			else if(!activeUserEntity.isPresent())
			{
				return this.buildInvalidSessionResponse();
			}
			else     
			{
				modelandview = new ModelAndView("redirect:/" + ViewNames.MAIN_MENU.getViewName())
					.addObject(ViewModelNames.ERROR_MESSAGE.getValue(), QueryParameterMessages.NOT_DEFINED.getMessage());
			}
		//return new ModelAndView(ViewModelNames.EMPLOYEE_TYPES.getValue());
		return modelandview;
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public ModelAndView startWithEmployee(
		@PathVariable final UUID employeeId,
		@RequestParam final Map<String, String> queryParameters,
		final HttpServletRequest request
	) {

		final Optional<ActiveUserEntity> activeUserEntity =
			this.getCurrentUser(request);

		if (!activeUserEntity.isPresent()) {
			return this.buildInvalidSessionResponse();
		} else if (!this.isElevatedUser(activeUserEntity.get())) {
			return this.buildNoPermissionsResponse();
		} else {
			Employee employee = ((Object) this.employeeQuery).setRecordID(employeeId).execute();

			ModelAndView modelandview = new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName().addObject(ViewModelNames.EMPLOYEE.getValue(), employee));
		}
		

		// TODO: Query the employee details using the request route parameter
		// TODO: Serve up the page
		return new ModelAndView(ViewModelNames.EMPLOYEE_TYPES.getValue());
		
	}

	// Helper methods
	private boolean activeUserExists() {
		// TODO: Helper method to determine if any active users Exist
		return this.activeEmployeeExistsQuery.isPresent();
	}
}
