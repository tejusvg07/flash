package hello;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	@Qualifier("jdbcConnection")
	protected JdbcTemplate jdbcConn;

	@Autowired
	private MainInterface mainInterface;

	@GetMapping(path = "/exceptiondetails")
	public @ResponseBody List<ExceptionDetailsModal> exceptiondetails() {
		return mainInterface.getExceptionDetails();

	}

	@GetMapping(path = "/partydetails")
	public @ResponseBody List<PartyDetailsModal> partydetails(@RequestParam String tempId) {
		System.out.println("tempid n entitytype is" + tempId );
		return mainInterface.getPartyDetails(tempId);

	}

}
