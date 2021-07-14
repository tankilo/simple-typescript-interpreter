package com.tankilo.typescript.interpreter.web.controller;

import com.tankilo.typescript.interpreter.ast.generator.AstService;
import com.tankilo.typescript.interpreter.ast.generator.SyntaxException;
import com.tankilo.typescript.interpreter.core.InterpreterException;
import com.tankilo.typescript.interpreter.core.service.Context;
import com.tankilo.typescript.interpreter.core.service.DSLService;
import com.tankilo.typescript.interpreter.core.traverse.TypedValue;
import com.tankilo.typescript.interpreter.web.vo.InterpreteRequest;
import com.tankilo.typescript.interpreter.web.vo.InterpreteResult;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
@RestController
@RequestMapping("/playground")
public class PlayGroundController {

    @Autowired
    private AstService astService;

    @Autowired
    private DSLService dslService;

    @PostMapping("/interprete")
    public InterpreteResult interprete(@RequestBody InterpreteRequest request) {
        InterpreteResult result = new InterpreteResult();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (PrintStream ps = new PrintStream(buffer)) {
            System.setOut(ps);
            String astJson = astService.parse(request.getCode());
            TypedValue typedValue = dslService.evalExpression(astJson, new Context());
            if (typedValue != null) {
                result.setReturnValue(ObjectUtils.nullSafeToString(typedValue.getValue()));
            } else {
                result.setReturnValue("undefined");
            }
            stopWatch.stop();
            result.setTimeCost(stopWatch.getTotalTimeMillis());
            appendConsoleOutput(result, buffer);
        } catch (SyntaxException | InterpreterException e) {
            stopWatch.stop();
            result.setSuccessful(false);
            result.setTimeCost(stopWatch.getTotalTimeMillis());
            String stacktrace = ExceptionUtils.getStackTrace(e);
            appendConsoleOutput(result, buffer);
            result.appendConsoleOutput(stacktrace);
        }
        result.setSuccessful(true);
        return result;
    }

    private void appendConsoleOutput(InterpreteResult result, ByteArrayOutputStream buffer) {
        System.setOut(System.out);
        String content = buffer.toString();
        buffer.reset();
        result.appendConsoleOutput(content);
    }
}


