import org.springframework.dao.DataIntegrityViolationException;

@ExceptionHandler(DataIntegrityViolationException.class)
public ResponseEntity<ApiErrorResponse> handleDataIntegrity(
        DataIntegrityViolationException ex) {

    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new ApiErrorResponse(400, "Email already exists"));
}
