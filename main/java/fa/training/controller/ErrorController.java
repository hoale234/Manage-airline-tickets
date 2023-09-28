package fa.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * Controller class to handle rendering error pages for different HTTP error codes.
 * 
 * This class manages rendering error pages and providing appropriate error messages based on the HTTP error codes.
 * 
 * @Author HoaLD6
 * Date of Birth: 03/04/2000
 */
@Controller
public class ErrorController {
    /**
     * Renders the error page for the specified HTTP error code.
     * 
     * @param httpRequest The HttpServletRequest object.
     * @return A ModelAndView for the error page with relevant error code and message.
     * @Author HoaLD6
     * Date of Birth: 03/04/2000
     */
    @RequestMapping(value = "errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

        ModelAndView errorPage = new ModelAndView("Error");
        String errorMsg = "";
        int errorCode = 0;
        int httpErrorCode = getErrorCode(httpRequest);

        switch (httpErrorCode) {
        case 400: {
            errorCode = 400;
            errorMsg = "Http Error Code: 400. Bad Request";
            break;
        }
        case 401: {
            errorCode = 401;
            errorMsg = "Http Error Code: 401. Unauthorized";
            break;
        }
        case 404: {
            errorCode = 404;
            errorMsg = "Http Error Code: 404. Resource not found";
            break;
        }
        case 500: {
            errorCode = 500;
            errorMsg = "Http Error Code: 500. Internal Server Error";
            break;
        }
        }
        errorPage.addObject("errorCode", errorCode);
        errorPage.addObject("errorMsg", errorMsg);
        return errorPage;
    }
    /**
     * Retrieves the error code from the HttpServletRequest.
     * 
     * @param httpRequest The HttpServletRequest object.
     * @return The error code associated with the request.
     * @Author HoaLD6
     * Date of Birth: 03/04/2000
     */
    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
    }
}