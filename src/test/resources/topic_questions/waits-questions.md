### 1. What is selenium synchronization?
   A: Selenium synchronization is the process of managing the timing between code execution and web application rendering.

### 2. Why is Thread.sleep() not a good way to handle synchroniztion?
   A: Thread.sleep() pauses the execution for a fixed duration, and that leads to in efficiency in the executioin. It is hardcoded, not reliable and not flexible.

### 3. What are the types of synchronization strategies on Selenium waits?
   There are 3 types of waits:
    1. Implicit Wait
    2. Explicit Wait
    3. Fluent Wait

### 4. What are implicit waits?
- Implicit waits will have a set amout of time we allow to timeout. Implicit wait will try to lacate an element every half send and once the element can be located in html it will proceed to the next line.
  Implicit waits do apply for the whole dirver instance, meaning that all elements that are in a particular driver will have this timelimit of locating the elements.

- If the locator is incorrect then implicit wait will take the time set to wait and after it will throw - NoSuchElementExcepotion.

Having a driver we use driver.manage().timeouts().implicitWait(Duration.ofSeconds(10));

### 5. What are explicit waits?
- Explicit waits will be set for specific elements. It does not apply for the whole driver instance.
- It allows us to use certain conditions to be met.
- There is a default polling time that is 0.5 seconds (500mils)

- Usually we will create an object of Wait<WebDriver> wait = WebDriverWait(Dirver, Dureation.ofSeconds(10));
- wait.until(ExpectedConditons.condition())
- What are some common conditions we use?
    - visibilityOf, invisibilityOf, elementToBeClickable, textPresence


### 6. What are fluent waits?
- They are similar to explicit waits, they get applied to specific elements and we can set what is the condition to be met.
- In addition we have now the ability to customize some details about how the wait will be applied.
- Some customizations would be:
- set polling time freq.
- ingnore some exceptions while waiting
- set a specific message to be shown when the condition is not met

```java 
        Wait<WebDriver> fluentWait = new FluentWait<>(Driver.getDriver())
        .withTimeout(Duration.ofSeconds(10))
        .pollingEvery(Duration.ofMillis(250))
        .ignoring(NoSuchElementException.class)
        .withMessage("The element failed to locate withing 10 seconds with palling time of 250 mills");

        fluentWait.until(ExpectedConditions.visibilityOf(herokuAppPage.message));
```