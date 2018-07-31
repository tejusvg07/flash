package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
public class MainImpl implements MainInterface{
    @Autowired
    @Qualifier("jdbcConnection")
    protected JdbcTemplate DbPulseDbConn;
    
    @Override
    public List<ExceptionDetailsModal> getExceptionDetails(){
    	   String excpt = "select * from  exception";
           
           List<ExceptionDetailsModal> md =  DbPulseDbConn.query(excpt, new BeanPropertyRowMapper<ExceptionDetailsModal>(ExceptionDetailsModal.class));
           
           return md;
    	
    }
    
  
    	 @Override
    	    public List<PartyDetailsModal> getPartyDetails(String PTY_ID){
    	    	
    	    	System.out.println(PTY_ID);
    	    	   String prt = "select * from  party_data where PTY_ID = "+PTY_ID;
    	           
    	           List<PartyDetailsModal> pt =  DbPulseDbConn.query(prt, new BeanPropertyRowMapper<PartyDetailsModal>(PartyDetailsModal.class));
    	           
    	           return pt;
    	    	
    	    } 




    	}