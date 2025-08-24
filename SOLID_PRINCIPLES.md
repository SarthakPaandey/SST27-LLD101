# SOLID Principles

SOLID is an acronym for five design principles intended to make software designs more understandable, flexible, and maintainable. These principles were introduced by Robert C. Martin and are fundamental to object-oriented design.

## 1. **S - Single Responsibility Principle (SRP)**

**Definition:** A class should have only one reason to change, meaning it should have only one responsibility.

**What it means:** Each class should focus on doing one thing well. If a class has multiple responsibilities, it becomes harder to maintain and modify.

**Example:**
```java
// ❌ Bad: Multiple responsibilities
class User {
    void saveToDatabase() { /* database logic */ }
    void sendEmail() { /* email logic */ }
    void validateData() { /* validation logic */ }
}

// ✅ Good: Single responsibility
class User {
    void validateData() { /* only validation logic */ }
}

class UserRepository {
    void saveToDatabase() { /* only database logic */ }
}

class EmailService {
    void sendEmail() { /* only email logic */ }
}
```

## 2. **O - Open/Closed Principle (OCP)**

**Definition:** Software entities (classes, modules, functions) should be open for extension but closed for modification.

**What it means:** You should be able to add new functionality without changing existing code. Use abstraction and polymorphism to achieve this.

**Example:**
```java
// ❌ Bad: Need to modify existing code
class Rectangle {
    double width, height;
}

class Circle {
    double radius;
}

class AreaCalculator {
    double calculateArea(Object shape) {
        if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return r.width * r.height;
        } else if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return Math.PI * c.radius * c.radius;
        }
        return 0;
    }
}

// ✅ Good: Open for extension, closed for modification
interface Shape {
    double calculateArea();
}

class Rectangle implements Shape {
    double width, height;
    
    @Override
    public double calculateArea() {
        return width * height;
    }
}

class Circle implements Shape {
    double radius;
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class AreaCalculator {
    double calculateArea(Shape shape) {
        return shape.calculateArea(); // No modification needed for new shapes
    }
}
```

## 3. **L - Liskov Substitution Principle (LSP)**

**Definition:** Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.

**What it means:** A subclass should behave in such a way that it won't cause problems when used instead of the parent class.

**Example:**
```java
// ❌ Bad: Violates LSP
class Rectangle {
    protected int width, height;
    
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    public int getArea() { return width * height; }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // Changes height too!
    }
    
    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height; // Changes width too!
    }
}

// ✅ Good: Follows LSP
interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    protected int width, height;
    
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    public int getArea() { return width * height; }
}

class Square implements Shape {
    private int side;
    
    public void setSide(int side) { this.side = side; }
    public int getArea() { return side * side; }
}
```

## 4. **I - Interface Segregation Principle (ISP)**

**Definition:** Clients should not be forced to depend on interfaces they do not use. Many client-specific interfaces are better than one general-purpose interface.

**What it means:** Break large interfaces into smaller, more specific ones so that clients only need to know about the methods they actually use.

**Example:**
```java
// ❌ Bad: One large interface
interface Worker {
    void work();
    void eat();
    void sleep();
}

class Robot implements Worker {
    public void work() { /* can work */ }
    public void eat() { /* robots don't eat! */ }
    public void sleep() { /* robots don't sleep! */ }
}

// ✅ Good: Segregated interfaces
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

class Human implements Workable, Eatable, Sleepable {
    public void work() { /* can work */ }
    public void eat() { /* can eat */ }
    public void sleep() { /* can sleep */ }
}

class Robot implements Workable {
    public void work() { /* can work */ }
    // No need to implement eat() or sleep()
}
```

## 5. **D - Dependency Inversion Principle (DIP)**

**Definition:** High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.

**What it means:** Depend on abstractions (interfaces) rather than concrete implementations. This promotes loose coupling and makes code more flexible.

**Example:**
```java
// ❌ Bad: High-level depends on low-level
class EmailNotifier {
    void sendEmail(String message) {
        // Direct dependency on email service
    }
}

class OrderService {
    private EmailNotifier emailNotifier = new EmailNotifier(); // Tight coupling
    
    void placeOrder() {
        // process order
        emailNotifier.sendEmail("Order placed");
    }
}

// ✅ Good: Both depend on abstraction
interface NotificationService {
    void sendNotification(String message);
}

class EmailNotifier implements NotificationService {
    public void sendNotification(String message) {
        // email implementation
    }
}

class SMSNotifier implements NotificationService {
    public void sendNotification(String message) {
        // SMS implementation
    }
}

class OrderService {
    private NotificationService notifier; // Depends on abstraction
    
    public OrderService(NotificationService notifier) { // Dependency injection
        this.notifier = notifier;
    }
    
    void placeOrder() {
        // process order
        notifier.sendNotification("Order placed");
    }
}
```

## **Benefits of SOLID Principles:**

1. **Maintainability:** Code is easier to understand and modify
2. **Extensibility:** New features can be added without changing existing code
3. **Testability:** Code is easier to unit test
4. **Reusability:** Components can be reused in different contexts
5. **Flexibility:** System is more adaptable to changing requirements

## **When to Apply:**

- During the initial design phase
- When refactoring existing code
- When reviewing code for improvements
- When designing new features or modules

Remember: SOLID principles are guidelines, not strict rules. Apply them thoughtfully based on your specific context and requirements.
