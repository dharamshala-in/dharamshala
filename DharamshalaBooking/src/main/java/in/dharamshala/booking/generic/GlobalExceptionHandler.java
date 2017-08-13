package in.dharamshala.booking.generic;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);
	public static final String DEFAULT_ERROR_VIEW = "error";
	
	
	
	@ExceptionHandler(value = Exception.class)
	  public ModelAndView
	  defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
	    
	    if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
	    {
	    	logger.error("error occured "+e);
	      throw e;
	    }
	   
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", e);
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName(DEFAULT_ERROR_VIEW);
	    logger.error("exception occured::::"+e.getMessage());
	    e.printStackTrace();
	    return mav;
	}
}
