# Unhandled Exception in Scala Future

This repository demonstrates a common error in Scala: unhandled exceptions within `Future`s.  The `bug.scala` file showcases the problem, where an exception thrown inside a `Future` is not properly caught, potentially leading to application instability. The `bugSolution.scala` file provides a corrected version with improved exception handling.

## Problem
The original code uses `onComplete` to handle the result of a `Future`. However, if an exception occurs within the `Future`, it might not be caught properly, leading to silent failures or unexpected application behavior. 

## Solution
The solution demonstrates using `recover` or `recoverWith` to gracefully handle exceptions that occur within the `Future`. This ensures that any exceptions are caught and handled appropriately, preventing application crashes and providing more robust error handling.