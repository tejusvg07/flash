package hello;

import java.util.List;


public interface MainInterface {
	
	List<ExceptionDetailsModal> getExceptionDetails();
	List<PartyDetailsModal> getPartyDetails(String tempId);

}
