# Firefly Math Exceptions

Lightweight exception implementation utilized by all firefly-math modules.

## Objectives
- Be easily adoptable by other Java math modules in the ecosystem
- Standarize the unique code, trigger, and context for throwing the exception
- Minimize the lines of code required to check for and throw the exception

## Features
- One [MathException class](https://github.com/firefly-math/firefly-math-exceptions/blob/master/src/main/java/com/fireflysemantics/math/exception/MathException.java) for all modules
- One [ExceptionFactory](https://github.com/firefly-math/firefly-math-exceptions/blob/master/src/main/java/com/fireflysemantics/math/exception/ExceptionFactory.java) per module.  Each factory method performs the check for the exception before throwing it, while also standardizing the key set used to construct the values that form the context for the exception.
- Set of enumerized codes per module indicating exception root cause
- Exception bound context providing key based lookup for parameters that led to the exception being thrown
- Fluid API for constructing the exception context
- Direct retrieval of the name of the class that originated the exception
- Direct retrieval of the method name that originated the exception
- Detailed root cause analysis per the exception context


## Installation

See [installation](https://github.com/firefly-math/firefly-math#installation)

## Usage

The below snippets are taken from the [MathExceptionTest](https://github.com/firefly-math/firefly-math-exceptions/blob/master/src/test/java/com/fireflysemantics/math/exceptions/MathExceptionTest.java).  See the other [firefly-math](https://github.com/firefly-math) modules for examples of how apply this exception module with other math modules. 

#### Create an exception with a given code 
``` java
new MathException(NUMBER_TOO_SMALL)
```

#### Check the exception code
``` java
try {
    throw new MathException(NUMBER_TOO_SMALL);
} catch (MathException e) {
    assertEquals(e.getType(), NUMBER_TOO_SMALL);
}
```

#### Analyze the Exception Context

``` java
try {
    throw new MathException(NUMBER_TOO_SMALL).put(CONSTRAINT, 2).put(VALUE, 1);
} catch (MathException e) {
    assertEquals(e.get(CONSTRAINT), 2);
    assertEquals(e.get(VALUE), 1);
    assertTrue(e.getKeys().contains(VALUE));
    assertTrue(e.getKeys().contains(CONSTRAINT));
    assertEquals(e.getMethodName(), "verifyContext");
    assertEquals(e.getClassName(), this.getClass().getName());
}
```

#### Use the Base Module Factory to Throw an Exception
``` java
try {
    ExceptionFactory.checkNumberTooSmall(VALUE, 1, 2);
    fail("Should move on to catch");
} catch (MathException e) {
    assertTrue(e.getType() == NUMBER_TOO_SMALL);
    assertEquals(e.get(CONSTRAINT), new Integer(2));
    assertEquals(e.get(VALUE), new Integer(1));
}
```
