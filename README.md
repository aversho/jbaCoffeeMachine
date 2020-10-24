Stage 4/6: Action!
==================
Description
-----------
Let's simulate an actual coffee machine. It has a limited supply of water, milk, coffee beans, and disposable cups. Also, it counts how much money it gets for selling coffee. The coffee machine has several options: first, it needs to be able to sell coffee. It can make different varieties of coffee: espresso, latte, and cappuccino. Of course, each variety requires a different amount of supplies, except that all of them requires only one disposable cup. Second, the coffee machine should be able to get replenished by a special worker. Third, another special worker should be able to take money from the coffee machine.

Write the program that can do one of these actions at a time. It reads one line from standard input, which can be "buy", "fill", "take". If you want to buy some coffee, input "buy". If you are a special worker and you think that it is time to fill out all the supplies for the coffee machine, input "fill". If you are another special worker and it is time to take the money from the coffee machine, input "take".

If the user writes "buy" then he must choose one of three varieties of coffee that the coffee machine can make: espresso, latte, or cappuccino.

For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
If the user writes "fill", the program should ask him how much water, milk, coffee, and how many disposable cups he wants to add to the coffee machine.

If the user writes "take" the program should give him all the money that it earned from selling coffee.

At the moment, the coffee machine has $550, 400 ml of water, 540 ml of milk, 120 g of coffee beans, and 9 disposable cups.

Write the program that prints the coffee machine’s state, processes one query from the user, and also prints the coffee machine’s state after that. Try to use methods to implement every action that the coffee machine can do.

Instruction
-----------
Write a program that offers to buy one cup of coffee or to fill the ingredients or to take its money. At the same time, the program should calculate how many ingredients it has left. And also display the number of ingredients before and after purchase.

Examples
--------

An espresso should be as number 1 in the list, a latte as number 2 and a cappuccino as number 3.
Options also should be named as "buy", "fill", "take".
The symbol > represents the user input. Notice that it's not the part of the input.

Example 1
---------

The coffee machine has:
400 of water
540 of milk
120 of coffee beans
9 of disposable cups
550 of money

Write action (buy, fill, take): 
* `> buy`
* `What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:` 
* `> 3`

The coffee machine has:
200 of water
440 of milk
108 of coffee beans
8 of disposable cups
556 of money

Example 2
---------

The coffee machine has:
400 of water
540 of milk
120 of coffee beans
9 of disposable cups
550 of money

Write action (buy, fill, take): 
* `> fill`
* `Write how many ml of water do you want to add:` 
* `> 2000`
* `Write how many ml of milk do you want to add:` 
* `> 500`
* `Write how many grams of coffee beans do you want to add:` 
* `> 100`
* `Write how many disposable cups of coffee do you want to add:` 
* `> 10`

The coffee machine has:
2400 of water
1040 of milk
220 of coffee beans
19 of disposable cups
550 of money

Example 3
---------

The coffee machine has:
400 of water
540 of milk
120 of coffee beans
9 of disposable cups
550 of money

Write action (buy, fill, take): 
* `> take`
* `I gave you $550`

The coffee machine has:
400 of water
540 of milk
120 of coffee beans
9 of disposable cups
0 of money