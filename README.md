# BUdget_SImple - (BU_SI)

This app aims at helping everyone to manage their family monthly budget.


## The project

What is a family monthly budget ?
This is the difference between incomes and expenses within a specific period (a calendar month).
Expenses include both fixed and variable costs.
If you know the amount of fixed monthly expenses and the amount of the variable monthly expenses, we can then infer the remaining budget that's left for savings, leisure, restaurants, activities, etc...
This inferred amount is what you are left with until the end of the month to live.
Being able to manage this remaining budget the best way, is critical and not always easy.

### Budget simple

I want to be able to manage the family monthly budget on a simple app.
When I log in to my profile, I can see all key figures that help me to manage the family monthly budget, so that I can decide whether I may go ahead with a purchase or not.
From the same dashboard, I can add a new transaction that replicate the transaction I will see on the bank account statement after purchasing an item from any store.
The dashboard is then updated with the foreseen remaining budget for the current month.

The user logs in and get to the main webpage - the user's dashboard.
This dashboard is the main entry point of the app.
It allows the user to get a clear and large picture of the family monthly budget state.
It allows the user to manage fictitious bank accounts. This in turn aims at replicate the real bank account.

The user should avoid using the real account number or the real bank name when creating the "fictitious" bank account in the application.
When they want to create a bank account on the dashboard, the process should be the same as in real life, when they create a spreadsheet (i.e. they most likely give a random name to the file).
This application should avoid storing real data about the bank or the bank account.

### Objectives

The application has to be accessible :

https://www.webaccessibilitychecklist.com/

https://www.a11yproject.com/checklist/


The application should implement S.O.L.I.D. principles:

- S = Single responsability principle - A class should do one thing.
- O = Open/close principle - a class should be opened to extensions but closed to modifications
- L = Liskov principle - object of a subclass should behave the same way as the object of its superclass. Replacing the superclass object by one of its subclass object should not break the app.
- I = Interface segregation principle
- D = Inversion of control - dependency inversion principle


Testing is one of the most important aspect of programming.
The application will be developed using the TDD approach.

- You may not write production code until you have written a failing unit test.
- You may not write more of a unit test than is sufficient to fail, and not compiling is failing.
- You may not write more production code than is sufficient to pass the currently failing test.


### Environment

Java 17 openjdk
maven
Junit
Spring
Mariadb

Intellij Idea


## Definitions

A bank account is a list of transactions and the balance is the total amount of all its transactions.
A bank account can be described with :

    - the alias
    - the list of financial transactions
    - the balance
    - the type (current, savings, etc...)

A financial transaction is represented by a new line within the bank account.
A financial transaction can be described with :

	- the date
	- the recipient
    - the description (optional)
	- the payment method
	- the amount
	- the periodicity
	
	- later :
	
		* VAT amount
		* Category

The dashboard shows:

	- How much I spend on fixed costs each and every month.
	- How much I spent on fixed but not mandatory / vital costs. (subscriptions to services like Netlfix, spotify, etc)
	- Remaining budget for the month.
	- Five or ten last transactions.
	
	- later :
	
		* amount of taxes paid over the month (VAT for instance).
		* amount of savings.
		* amount of forseen savings on a specific period of time.

From the dashboard I can add a new financial transaction, edit or delete a financial transaction.

When creating a new financial transaction, the user have to specify :

	- transaction date
	- beneficiary
	- amount of the transaction
	- payment method
	
	- later : 
		
		* is the transaction mandatory / necessary / vital (utility bills, rental, groceries)
		* category
		* occurence (monthly for instance)


## User stories

As a ... I want to ... so that ...

- [ ] As a user I want to create a bank account, so that I can compare the bank statement and the newly created "fictitious" bank account.
- [ ] As a user I want to add a payment to the list of the payment done "this month", so that I can track the family monthly budget.
- [ ] As a user I want to have an overview of the family monthly budget, so I can make relevant decision and planning.

---

##### *End of document*

---
