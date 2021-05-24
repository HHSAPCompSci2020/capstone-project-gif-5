AP Computer Science Final Project - README Template


Instructions:
The first step in creating an excellent APCS final project is to write up a README. At this stage, this README file acts as your project proposal. Once you’ve filled in all components, Shelby will read through it and suggest edits. Ultimately, you need a document that adequately describes your project idea and we must agree on this plan.


Have one member of your group make a copy of this Google Doc. Then, they should share it with all other members so that every group member has edit permissions.


There’s a lot of parts of this document that you might not have full answers for yet. Because you haven’t written the program yet, it’s difficult to think about the instructions or which group members will do which parts. Even though this is hard to think about, you must have something in these sections that acts as your current plan. However, during the course of the project, you’ll continuously update this document. This means that you will not be held to exactly what you put here - components of this document can change (and it’s pretty common!).


There is one exception: the Features List section. Once Shelby OKs your README, the Features List section cannot be modified. For this reason, it is most important that you get a solid idea of what you want to make and the primary features it will have now.


Talk with your group. Consider drawing some pictures of what you think your project might look like. Be precise. When you’re ready, fill this out together. Each component in brackets below ( [these things] ) should be replaced with your ideas. Note that there are several sample READMEs posted on this assignment for you to use as guidance.


-------------------When README is finalized, remove everything above this line--------------------


The Wizard’s Dungeon
Authors: Ido Tal, Gilad Bitton, Franklin Wang
Revision: 4/19


Introduction: 
[In a few paragraphs totaling about ½ page, introduce the high-level concept of your program. What this looks like depends a lot on what type of thing you are making. An introduction for an application will look different than one for a game. In general, your introduction should address questions like these:
What does your program do?
What problem does it solve? Why did you write it?
What is the story?
What are the rules? What is the goal?
Who would want to use your program?
What are the primary features of your program?






Our program is a dungeon crawling game. In the game your goal is to exit the dungeon by going from room to room. You see a bird’s eye view of your current room and the whole game would be 2D. To be able to move on to the next room, you would need to defeat all the enemies in the current room. The player would be able to defeat the enemies since they are a wizard with different elemental powers. By using these powers against the enemies you would do damage to them until they die. The powers will range from a normal magical burst, to a fire area of effect in front of you, an ice beam, and a lightning bolt. The enemies however won’t go down without a fight so we’ll have different types of enemies in each room trying to kill you before you kill them. Each enemy would have a different method of hurting you, be different sizes, and the player would need to use different abilities to defeat them. The player would need to defeat the enemies in order to continue and the rooms will be locked off until done so. Each room would also be different from one another, we want rooms to have things like pillars or bookshelves you can hide behind. Rooms get increasingly harder until you get to the last room which is the hardest. After you defeat it you would beat the game. If you would die at any time you would get a game over screen and have to restart the game. Our primary audience would be people from the ages of 5 - 19. This is because those types of people are bored in life and they want to have fun. There will be lots of cool mechanics and different types of monsters you can face.






Instructions:
[Explain how to use the program. This needs to be specific: 
Which keyboard keys will do what? 
Where will you need to click? 
Will you have menus that need to be navigated? What will they look like? 
Do actions need to be taken in a certain order?]


Once you start the game you will be spawned in the first dungeon. You would move around it using WASD. to shoot your elemental attacks you would press mouse1. To switch between elemental attacks you would press the spacebar. The 4 elemental attacks you have available to you are fire (low damage but burns over time), ice (relatively high damage and slows down enemies over time), lightning (high rate of fire but low damage), magic (In between all the others with no special effects). Throughout the dungeon you would encounter health potions which would regenerate you 50 HP. You should avoid enemies and enemy attacks to keep your health. Once you beat all the enemies in a room you could move on to the next one using the ladder. Try to make it to the last room, beat it,m and win! 


Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
[These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]
*  Being able to move around the dungeon and going from room to room. This will basically be a feature that makes your movement very smooth (nice to play on). You will be able to move very quickly and use acceleration.
*  The next feature would be basic attacks and being able to shoot magic balls and change the type of attack you are using.
*  Another important feature is having different mobs that have AI and are programmed to find a way to try to kill the player using their abilities.
*  Having more than one attack and the ability to change between them, you will be able to cycle through them and have different keybinds of each one.
*  Each room, enemy, player, or ability having their own custom made sprite (Which Ido would make). 


Want-to-have Features:
[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
*  Try to have at least 4 different attacks.
*  Trying to have at least 7 enemy types.
*  Adding different room designs and obstacles, like adding pillars and pits.
*  Adding a final boss to the game
*  Adding items you could find and use
Stretch Features:
[These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]
*  Making more everything, more bosses, more enemies, more room types, and more abilities.
* Making automated room designs making a possibility of infinite rooms once you beat the game 
*  Making a place where you can custom make your main character and create your own skins. He will be able to go into a menu and choose hair color and such.






Class List:
[This section lists the Java classes that make up the program and very briefly describes what each represents. It’s totally fine to put this section in list format and not to use full sentences.]


Enemy superclass
* The enemy superclass makes it very easy to create new enemies. All you have to do is change the way it follows the player, speed, damage, and range which will be fields, also you need to change sprite, animations and the way it attacks. Any special attacks would be added in the individual class. 
   * Goblin a small enemy that's fast and does a small amount of damage
   * Skeleton is a medium enemy that has long range attacks and does a low amount of damage
   * Giant A big yet slow enemy who has a lot of health and deals a lot of damage
   * Witch Can shoot magic balls at the player but also spawns skeletons over time. By far your most formidable foe.
WMagic 
* A magic ball for the witch to shoot
Arrow
* The arrow skeletons shoot
 WizardElement (A superclass with all components of an elemental power)
* Magic (default power; magic balls that in a straight line)
* Lightning (looks like a strike of lightning that is fast but does a small amount of damage)
* Fire (An attack with an area of affect in front of the player; has the ability to do the burn effect, which does damage to enemies overtime)
* Ice (an ice like burst in front of the player; does a good amount of damage and also has the chance to freeze the opponent, making them slower or even unable to move) 
Player 
* The player class will make a wizard sprite and make you be able to move and such. It will also create new elemental power. They will be using set elemental powers.
Dungeon
* A class representing the screen the player will play on. Also makes sure to create rooms with different enemies and such.
DungeonMaker
* Reads the specified dungeon text file and makes it a new dungeon.
MovingImage
* Represents every moving image in the dungeon, it is the super class for all the elements, enemies, and Player and it controls their sprite.
DrawingSurface
* Draws everything onto a canvas.
DungeonGame
* Is the main method for the game and it runs everything.
Wall
* A class representing walls that movingImages can’t cross.




Credits:
[Gives credit for project components. This includes both internal credit (your group members) and external credit (other people, websites, libraries). To do this:
* List the group members and describe how each member contributed to the completion of the final program. This could be classes written, art assets created, leadership/organizational skills exercises, or other tasks. Initially, this is how you plan on splitting the work.
* Give credit to all outside resources used. This includes downloaded images or sounds, external java libraries, parent/tutor/student coding help, etc.]


Ido: Creates sprites of the game and the player, dungeon, and movingImage classes, fire, dungeon game, wall, dungeon maker, and magic.

Gilad: Creates the enemy class and all of its subclasses, Also created the enemy attacks.


Franklin: Creates the WizardElement class and ice and lightning.


All of us: We all worked on DrawingSurface.


Additional credit to the processing library, which we used in our project.