package com.wasperversa.multicalculator;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Function;
import com.fathzer.soft.javaluator.Parameters;

import java.util.Iterator;

/**
 * An extension of {@link DoubleEvaluator} that supports additional mathematical functions:
 * <ul>
 *  <li><b>sqrt(x):</b> Square root of x.</li>
 *  <li><b>cbrt(x):</b> Cube root of x.</li>
 *  <li><b>asind(x):</b> Arc sine of x in degrees.</li>
 *  <li><b>acosd(x):</b> Arc cosine of x in degrees.</li>
 *  <li><b>atand(x):</b> Arc tangent of x in degrees.</li>
 * </ul>
 */
public class ExtendedDoubleEvaluator extends DoubleEvaluator {
    /** Defines the new function (square root).*/
    private static final Function SQRT = new Function("sqrt", 1);
    private static final Function CBRT = new Function("cbrt", 1);
    private static final Function ASIND = new Function("asind", 1);
    private static final Function ACOSD = new Function("acosd", 1);
    private static final Function ATAND = new Function("atand", 1);
    private static final Parameters PARAMS;

    static {
        // Gets the default DoubleEvaluator's parameters
        PARAMS = DoubleEvaluator.getDefaultParameters();
        // add the new sqrt function to these parameters
        PARAMS.add(SQRT);
        PARAMS.add(CBRT);
        PARAMS.add(ASIND);
        PARAMS.add(ACOSD);
        PARAMS.add(ATAND);
    }

    public ExtendedDoubleEvaluator() {
        super(PARAMS);
    }

    @Override
    public Double evaluate(Function function, Iterator<Double> arguments, Object evaluationContext) {
        if (function == SQRT) {
            // Implements the new function
            return Math.sqrt(arguments.next());
        }
        else if(function == CBRT)
        {
            return Math.cbrt(arguments.next());
        }
        else if(function == ASIND)
        {
            return Math.toDegrees(Math.asin(arguments.next()));
        }
        else if(function == ACOSD)
        {
            return Math.toDegrees(Math.acos(arguments.next()));
        }
        else if(function == ATAND)
        {
            return Math.toDegrees(Math.atan(arguments.next()));
        }
        else {
            // If it's another function, pass it to DoubleEvaluator
            return super.evaluate(function, arguments, evaluationContext);
        }
    }
}