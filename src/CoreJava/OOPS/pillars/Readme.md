//ways to achieve abstraction
/*
* 1. Abstract class
* 2. Interface
* */
diff between interface vs abstract class

Abstract class | interface
0-100%                100%
can have constructor                                Does not having constructor
to load state(instance variable) of the class
since we can't create object of abstract class


we can extend only one class                      using interface we can achieve multiple inheritence


Aspect	Abstract Class	Interface
Abstraction Level	Supports 0-100% abstraction (can have both abstract and concrete methods).	Supports 100% abstraction (only abstract methods until Java 7, can have default/static methods since Java 8).
Constructors	Can have constructors to initialize instance variables.	Cannot have constructors.
State Management	Can maintain state using instance variables (non-final, non-static variables are allowed).	Cannot maintain state; only public static final variables (constants) are allowed.
Inheritance	Supports single inheritance (can extend only one abstract or concrete class).	Supports multiple inheritance (can implement multiple interfaces).
Method Type	Can have both abstract methods (without a body) and concrete methods (with a body).	Can have abstract methods, default methods (from Java 8), and static methods (from Java 8).
Access Modifiers	Can have methods and variables with any access modifier (public, protected, private, etc.).	Methods in an interface are public abstract by default, and variables are public static final by default.
Performance	Faster because abstract classes are partially implemented.	Slower because all methods in interfaces are by default abstract (prior to Java 8).
Use Case	Used when classes share common functionality and state.	Used when classes share only behavior but no shared state.
Multiple Inheritance Conflict	Cannot resolve diamond problem (multiple inheritance conflict) if extended by multiple classes.	Can resolve diamond problem using the default methods introduced in Java 8.
Implementation Requirements	Subclasses extending an abstract class must implement all its abstract methods or remain abstract.	Classes implementing an interface must implement all its abstract methods.



Key Takeaways
Use abstract classes for shared behavior and state within a class hierarchy.
Use interfaces for defining behavioral contracts across unrelated classes or when multiple inheritance is required.
A combination of both can be used in complex designs, with abstract classes for shared state/behavior and interfaces for additional behavior contracts.


