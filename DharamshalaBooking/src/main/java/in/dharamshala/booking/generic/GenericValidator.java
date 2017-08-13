package in.dharamshala.booking.generic;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

public  class GenericValidator  {
	protected final Logger log = LoggerFactory.getLogger(getClass());
    
    protected Errors errors;

 protected final String NUMBER = "\\d*(\\.\\d+)?";
    protected final String LONG = "\\d{1,10}";
    protected final String AMOUNT = "\\d{1,18}";
    protected final String UNIT = "\\d{1,18}(\\.\\d{1,3})?";
    protected final String PRICE = "\\d{1,18}(\\.\\d{1,2})?";
    protected final String FX_RATE = "\\d{1,18}(\\.\\d{1,4})?";
    protected final String DIGITS = "\\d*";
    //protected final String ALPHA = "[[a-z|A-Z]+(\\s?)]+[a-z|A-Z]+";
    protected final String ALPHA = "[a-z|A-Z]+";
    protected final String ALPHA_NUM = "[a-z|A-Z|0-9]+";
    protected final String ALPHA_WITH_SPACE = "[a-z|A-Z]+((\\s)*[a-z|A-Z]+)*";
    protected final String CHARACTER = "[a-z|A-Z]";
    protected final String PHONE_FAX = "[0-9|-]*";
    protected final String CODE = "[a-z|A-Z|0-9|-]*";
    protected final String ALPHA_NUM_CHAR = "[\\w]+";
    protected final String ALPHA_SPACE = "[a-z|A-Z|\\s]+";

	//protected final String EMAIL = "[\\w|\\-|.]*[\\w]{1,}(@)[\\w|-]+(\\.[\\w|-]+){1,3}";
    protected final String EMAIL = "[\\w|\\-|.]*[\\w]{1,}(@)[\\w|-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    //protected final String URL = "[a-z|A-Z|0-9]{1,3}(.)[[a-z|A-Z|0-9]+[\\w|-]*](.)[a-z|A-Z|0-9]{1,3}[(/)[\\w|-|.|?]*]*[a-z|A-Z|0-9]{1,}";

    protected final String SCRIPT = "[\\w|\\s|@|/|\\.|,|-]*";
    //protected final String CURRENCY_DOLLAR = "[a-z|A-Z|0-9|@|_|-|\\s|/]*";
    //protected final String PASSWORD = "[[a-z|A-Z|0-9]*[[A-Z][0-9]|[0-9][A-Z]]+[a-z|A-Z|0-9]*]";
    protected final String DESCRIPTION = "[a-z|A-Z|0-9]+((\\s)*[a-z|A-Z|0-9]+)*";
    protected final String MIN_CHAR = "[a-z|A-Z|0-9]{3,}";
    protected final String ALPHA_NUM_COMMA_DOT = "[a-z|A-Z|0-9|\\s|\\.|,|-]*";
    protected final String ALPHA_COMMA_DOT = "[a-z|A-Z|,|\\.|\\s|-]*";
    protected final String PERCENT = "\\d{1,3}(\\.\\d{1,2})?";
    protected final String DAYS_OFF = "[1|2|3|0|4|5|6|7]+";//Added "0" to allow week_off in bank_params
	protected final String PHONE_NOS = "[\\w|\\s|@|/|\\.|,|-|+|(|)]*";
    protected final String DATE="VALIDATE_DATE";
    protected final String NAME="[\\w|\\s|\\.|'|&|/|\\-]*";
    protected final String ALPHA_NUM_UNDERSCORE = "[a-z|A-Z|0-9|_]+";
    
    
    public boolean isEmptyOrWhitespace(Object value)
    {
        
            log.debug("THE VALUE IS  ::::"+value);
            if(value == null || !StringUtils.hasText(value.toString()))
            {
                 log.info("string value is null or value is null");
                 return true;
            }
        
        return false;
    }
    public boolean lengthCheck(String value,int vlength)
    {
         
            log.debug("OUTSIDE IF ::THE VALUE IS  ::::"+value);
            if(value!=null)
            {
                log.debug(" THE LENGHT TO BE CHECKED IS :::"+vlength);
                
                if(value!=null && value.length()>vlength)
                {
                    log.debug("THE VALUE IS  ::::"+value+" length is::"+value.length()+" THE FIELD NAME IS ::"+vlength);
                     return false;
                }
            }
        
        return true;
    }
    public boolean beforeDateValidation(String valueOne,String valueTwo)
    {
    	SimpleDateFormat lSimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		if (valueOne == null || valueOne.equals("")) {
			return false;
		}

		Date dateOne = lSimpleDateFormat.parse(valueOne, new ParsePosition(0));
		
        Date dateTwo=lSimpleDateFormat.parse(valueTwo, new ParsePosition(0));;
        log.debug("THE DATE FIELDS ARE "+valueOne+":::"+valueTwo);

        if(dateOne!=null && dateTwo!=null)
        {
            log.debug("THE DATE :"+dateOne+"IS AFTER DATE OF :"+dateTwo+":::"+dateOne.after(dateTwo));
            if(!dateOne.after(dateTwo))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean dateValidation(String dateValue)
    {
    	
    	if(dateValue == null){
			return false;
		}
            try
            {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
               
                
                log.debug(" THE DATE TO BE FORMATTED IS ::::" + dateValue);
               
                
                sdf.parse(dateValue.trim());
                log.debug(" THE FORMATTED DATE IS ::::" + sdf.parse(dateValue));
                
            } catch (Exception ex)
            {
                ex.printStackTrace();
                return false;
            }
        
        return true;
    }
    public boolean positiveNumberValidation(Object value)
    {
       
            if(value!=null)
            {
                if(value instanceof Long && (((Long)value)<0))
                {
                    log.debug("THE LONG VALUE IS :::"+value);
                    return false;
                }
                else if(value instanceof Double && (((Double)value).doubleValue() <0))
                {
                    log.debug("THE BIGDECIMAL VALUE IS :::"+value);
                    return false;
                }else if(value instanceof Integer && (((Integer)value).intValue()<0))
                {
                    log.debug("THE Integer VALUE IS :::"+value);
                    return false;
                }
            }
        
        return true;
    }
      public boolean timeStampValidation(Set<String> attributeSet)
    {
        
        Object value =null;
        for(String attribute:attributeSet)
        {

            value = errors.getFieldValue(attribute);
            if(value!=null)
            {
                try
                {
                    if(((String)value).contains(":"))
                    {
                        String timeValues[]=((String)value).split(":");
                        log.debug(" THE TIME VALUES ARE :::"+Integer.parseInt(timeValues[0])+"::"+Integer.parseInt(timeValues[1]));
                        if(Integer.parseInt(timeValues[0])>24 && Integer.parseInt(timeValues[1])>60)
                        {
                            return false;
                        }

                    }
                    else
                    {
                        return false;
                   
                    }	
                }catch(Exception ex)
                {	
                	return false;
                }
            }
        }
        return true;
    }
    /**
     * This method is to check various pattern
     * @param attributeMap
     */


      public boolean checkPattern(Object obj,String strPattern ) {
    	  boolean result =true;
          try {

        	  Matcher match;
        	  log.debug("Pattern check for "+strPattern+" :: "+obj);
        	  if(obj!=null && !obj.toString().equals("") ) {
	        	  Pattern acceptedPattern = Pattern.compile(strPattern);
	        	  match = acceptedPattern.matcher(obj.toString());
	              result = match.matches();
	              log.debug("the boolean is :- "+result);
	              if(!result) {
	                log.info("Pattern checking failed for :"+obj);
	                result=false;
	                return result;
	            }
        	  } 
          }catch(PatternSyntaxException pse) {
              pse.printStackTrace();
              return false;
          }catch(Exception e) {
              e.printStackTrace();
              return false;
          }
          return result;
      }
      
    public static void main(String args[]) {
    	
    	GenericValidator valid=new GenericValidator();
    	
    	try {
    		
    		//System.out.println("test result is ::"+valid.checkPattern("anshul $%",valid.NAME));
			//System.out.println("test result is ::"+valid.checkPattern("shweta@a.com",valid.EMAIL));
    		//System.out.println("test result is ::"+valid.lengthCheck("shweta@gmail.com",10));
			//System.out.println("test result is ::"+valid.dateValidation("210717"));
    		//System.out.println("test result is ::"+valid.beforeDateValidation("23/07/2017", "21/07/2017"));
    		System.out.println("test result is ::"+valid.positiveNumberValidation(-2111111111));
    		System.out.println("test result is ::"+valid.positiveNumberValidation(0L));
    		System.out.println("test result is ::"+valid.positiveNumberValidation(-210000000L));
    		System.out.println("test result is ::"+valid.positiveNumberValidation(-21.012));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}

}
