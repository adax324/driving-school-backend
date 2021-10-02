//package com.example.utils;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindException;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.jsp.PageContext;
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//public class ErrorHandler {
//
//
////    @ExceptionHandler(RuntimeException.class)
////    public ResponseEntity<Object> exception(RuntimeException exception) {
////        return new ResponseEntity<>("Testowy Błąd", HttpStatus.BAD_REQUEST);
////    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(BindException.class)
//    public ModelAndView handleValidationExceptions(HttpServletRequest req,
//            BindException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//
//
//        ModelAndView mav=new ModelAndView();
//        mav.addObject("exception",ex);
//        mav.addObject("url",req.getRequestURL());
//        mav.setViewName("/courses/quest/addQuest");
//        return mav;
//    }
//
//
//
//}
