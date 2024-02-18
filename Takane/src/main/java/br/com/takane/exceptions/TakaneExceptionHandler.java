package br.com.takane.exceptions;

import java.util.HashMap;
import java.util.Map;
import javax.naming.AuthenticationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import br.com.takane.response.TakaneResponse;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class TakaneExceptionHandler {

	@ExceptionHandler(RecursoNotFoundException.class)
	public ResponseEntity<TakaneResponse> myResourceNotFoundException(RecursoNotFoundException e) {
		String message = e.getMessage();
		TakaneResponse res = new TakaneResponse(message, false);
		return new ResponseEntity<TakaneResponse>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(TakaneException.class)
	public ResponseEntity<TakaneResponse> myAPIException(TakaneException e) {
		String message = e.getMessage();
		TakaneResponse res = new TakaneResponse(message, false);
		return new ResponseEntity<TakaneResponse>(res, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> myMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		Map<String, String> res = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach(err -> {
			String fieldName = ((FieldError) err).getField();
			String message = err.getDefaultMessage();
			res.put(fieldName, message);
		});
		return new ResponseEntity<Map<String, String>>(res, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, String>> myConstraintsVoilationException(ConstraintViolationException e) {
		Map<String, String> res = new HashMap<>();
		e.getConstraintViolations().forEach(voilation -> {
			String fieldName = voilation.getPropertyPath().toString();
			String message = voilation.getMessage();
			res.put(fieldName, message);
		});
		return new ResponseEntity<Map<String, String>>(res, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<String> myAuthenticationException(AuthenticationException e) {
		String res = e.getMessage();
		return new ResponseEntity<String>(res, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingPathVariableException.class)
	public ResponseEntity<TakaneResponse> myMissingPathVariableException(MissingPathVariableException e) {
		TakaneResponse res = new TakaneResponse(e.getMessage(), false);
		return new ResponseEntity<TakaneResponse>(res, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<TakaneResponse> myDataIntegrityException(DataIntegrityViolationException e) {
		TakaneResponse res = new TakaneResponse(e.getMessage(), false);
		return new ResponseEntity<TakaneResponse>(res, HttpStatus.BAD_REQUEST);
	}
}
