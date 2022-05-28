package uz.abbos.jparepositoryfirst.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHadnleController {


    @ExceptionHandler
    public ResponseEntity<?> BadRequst(BadRequestException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    public ResponseEntity<?> BadRequstError(BadRequestException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
