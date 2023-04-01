package dev.lissandrocunha.api.infra.exception;

import dev.lissandrocunha.api.domain.BusinessException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

    private record DadosErroValidacao(String campo, String message){
        public DadosErroValidacao(FieldError erro){
            this(
                    erro.getField(),
                    erro.getDefaultMessage()
            );
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErroValidacao>> tratarErro400(MethodArgumentNotValidException exception){

        var erros = exception.getFieldErrors();

        return ResponseEntity
                .badRequest()
                .body(
                        erros.stream()
                                .map(DadosErroValidacao::new)
                                .toList()
                );
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> tratarErrorRegraDeNegocio(BusinessException exception){
        return ResponseEntity
                .badRequest()
                .body(
                        exception.getMessage()
                );
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> tratarError404(){
        return ResponseEntity
                .notFound()
                .build();
    }



}
