cla
# Library Management System (Java)

A console-based Library Management System written in Java.


## Authors
- Student 1: AHMED FARDIN (202502010015)
- Student 2:  RUDER SHARMA(202501010273)

## Features
- Add books, magazines and DVDs
- Register library members
- Display all items and all members
- Borrow items (maximum 3 per member, no double borrowing)
- Return items with automatic late-fine calculation
- Loan rules demo that shows polymorphism

## Loan Rules

| Item     | Loan period | Fine per late day |
|----------|-------------|-------------------|
| Book     | 14 days     | RM 0.50           |
| Magazine | 7 days      | RM 0.20           |
| DVD      | 3 days      | RM 1.00           |

## OOP Concepts Used

| Concept | Where it is used |
|---------|------------------|
| Classes and Objects | Person, Member, LibraryItem, Book, Magazine, Dvd, Library, Main |
| Encapsulation | Private fields with getters and setters in every class |
| Inheritance | `Member extends Person`; `Book`, `Magazine`, `Dvd` extend `LibraryItem` |
| Polymorphism | Method overriding (`displayInfo()`, `getRole()`) and a `LibraryItem` list holding different item types |
| Abstraction | `LibraryItem` is an abstract class with abstract methods `getItemType()`, `getLoanPeriodDays()`, `getFinePerDay()` |

## Project Structure

```
Person.java      - superclass for people
Member.java      - library member (extends Person)
LibraryItem.java - abstract superclass for items
Book.java        - extends LibraryItem
Magazine.java    - extends LibraryItem
Dvd.java         - extends LibraryItem
Library.java     - manages items and members
Main.java        - console menu (program entry point)
```

## How to Run

Requires JDK 8 or newer.

```bash
git clone https://github.com/zinver/library-management-system.git
cd library-management-system
javac *.java
java Main
```

## Sample Menu

```
===== CITY UNIVERSITY LIBRARY =====
1. Add item
2. Register member
3. Display all items
4. Display all members
5. Borrow item
6. Return item
7. Show loan rules (polymorphism demo)
0. Exit
```