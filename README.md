# Firefly Math Exceptions

Exception implementation for all firefly-math modules

## Objectives
- One [exception class](https://github.com/firefly-math/firefly-math-exceptions/blob/master/src/main/java/com/fireflysemantics/math/exception/MathException.java) for all modules
- A factory per module for throwing exceptions ensuring that the exception context and code remains consistent throughout all modules
- A set of enumerized codes / types per module indicating the root cause of the thrown exception
- Provision of an exception context providing key based lookup for parameters that led to the exception being thrown
- Provision of a fluid API to manage the exception context
- The ability to directly retrieve the the name of the class that originated the exception
- The ability to directly retrieve the method name that originated the exception
- Detailed root cause analysis per the exception context


## Installation

See [installation](https://github.com/firefly-math/firefly-math#installation)

## Usage

Start with the [test](https://github.com/firefly-math/firefly-math-exceptions/blob/master/src/test/java/com/fireflysemantics/math/exceptions/MathExceptionTest.java).  It provides a runnable set of examples.  In addition here are a set of scenarios explaining how to go about utilizing this module in your own module [TODO].
