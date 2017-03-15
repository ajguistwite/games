//Adventure Game, Kaitlin Friscia, Jacqueline Fabian
//Andrew Guistwite

import scala.annotation.tailrec
import scala.io.StdIn

@tailrec def startGame(): Unit = {
  println("*********************************************************************")
  println("*********************************************************************")
  println("")
  println("Welcome to PROFESSOR BLAKE ESCAPE! You play as Professor Blake and you just woke up to realize you’re running late for a very important day of class. BUT, you have seem to have misplaced a few things the night before...  Find the Sandwich of Doom, Ultimate Plaid Shirt of Awesomeness, Mac-us Laptop-us, and of course, you’re car Keys in 20 Min time to get to Quinnipiac and enlighten your students. Navigate through your house to find the items scattered throughout the rooms, but travel carfully, there have been dangerous beast sightings all over your neighborhood...")
  println("")
  println("If you are having trouble, press H for help")
  println("")
  println("Are you ready to Play?")
  scala.io.StdIn.readLine("Type yes to begin >>").toUpperCase match {
    case "YES" => roomOne(1, Set())
    case "H" => help(); startGame()
    case "Q" => System.exit(0)
    case _ =>
      println("#################################################")
      println("When you are ready to begin please type \"yes\".")
    startGame()
  }
}

startGame()

def trap1(): Unit = {
  println("")
  println("You walk out the kitchen door to the outside world. All of a sudden,a giant mutated bananna comes out of nowhere and eats you...")
  println("*************YOU DIED****************")
  startGame()
}

def trap2(): Unit = {
  println("")
  println("You peer out the window for a couple seconds but then, rampaging vikings come throw a car sized pie at you")
  println("************DEATH BY VIKING PIE***********************")
  startGame()
}

def trap3(): Unit = {
  println("")
  println("You walk down the dark corridor to find a bunch of Minions and Skylanders in the corner")
  println("Suddenly they come alive and attack you thinking you are an evil giant")
  println("************DEATH BY TOYS***********************")
  startGame()
}

def help(): Unit = {
  println("")
  println("Press N to move forward, S to move back, W to move left, and E to move right")
  println("To check your time, press T")
  println("To check what items you have, press B")
  println("If you come across something secret, type in secret to see what happens")
  println("To quit, press Q")
  println("You will not be able to enter certain rooms unless you have the items parts prior to entering")
  println("")
}

def printBag(bag: Set[String]): Unit = {
  println("")
  println("Your have collected: " + bag.mkString(","))
  println("")
}

def printTime(time: Int): Unit = {
  println("")
  println("It has been " + time + " minute(s)")
  println("")
}

@tailrec def roomOne(time: Int, bag: Set[String]): Unit = {
  if(time == 20) {
    println("#############################")
    println("YOU RAN OUT OF TIME!")
    println("#############################")
    System.exit(0)
    startGame()
  }
  
  if(time == 15) {
    println("#############################")
    println("YOU ONLY HAVE 5 MORE MINUETES!")
    println("#############################")
  }
  println("")
  println("You are in your Bedroom!")
  println("There are 3 doors you can take, one forward, one to your right, and another to your left")
  println("Which way are you going to go?")
  
  
  
  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(bag); roomOne(time, bag)
    case "Q" => System.exit(0)
    case "H" => help(); roomOne(time, bag)
    case "N" => roomSix(time + 1, bag)
    case "T" => printTime(time); roomOne(time, bag)
    case "W" => roomThree(time + 1, bag)
    case "E" => roomTwo(time + 1, bag)
    case _ =>
      println("******ENTER A CORRECT DIRECTION******")
    roomOne(time, bag)
  }
}
@tailrec def roomTwo(time: Int, bag: Set[String]): Unit = {
  if(time == 20) {
    println("#############################")
    println("YOU RAN OUT OF TIME!")
    println("#############################")
    System.exit(0)
    startGame()
  }
  if(time == 15) {
    println("")
    println("#############################")
    println("YOU ONLY HAVE 5 MORE MINUETES!")
    println("#############################")
    println("")
  }
  println("")
  println("You are in the hall. Wonderful paintings and emeralds line the walls.")
  println("There are 3 doors you can take, one forward, one back, and another to your left")
  println("which way would you like to go?")
  
  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(bag); roomTwo(time, bag)
    case "Q" => System.exit(0)
    case "T" => printTime(time); roomTwo(time, bag)
    case "H" => help(); roomTwo(time, bag)
    case "N" => roomEight(time + 1, bag)
    case "W" => roomOne(time + 1, bag)
    case "E" => {
      println("You can't go that way champ")
      roomTwo(time, bag)
    }
    case "S" => {
      if (bag.contains("Part 2")) {
        roomSeven(time + 1, bag)
      } else {
        println("")
        println("Comeback with item 2 to enter")
        println("")
        roomTwo(time, bag)
      }
    }
    case _ => {
      println("******ENTER A CORRECT DIRECTION******")
      roomOne(time, bag)
    }
  }
}

@tailrec def roomThree(time: Int, bag: Set[String]): Unit = {
  println("")
  if(time == 20) {
    println("#############################")
    println("YOU RAN OUT OF TIME!")
    println("#############################")
    System.exit(0)
    startGame()
  }
  if(time == 15) {
    println("")
    println("#############################")
    println("YOU ONLY HAVE 5 MORE MINUETES!")
    println("#############################")
    println("")
  }
  val newbag = bag + "The Sandwich of Doom"
  println("")
  if (!(bag.contains("The Sandwich of Doom"))){
    println("*******You found The Sandwich of Doom!*********")
  }
  println("")
  println("You're in the Kitchen. So many wonderful smells, so many snacks...No time to waste though!")
  println("There are 2 doors inside: North or West?")
  println("Which door would you like to go through?")
  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(newbag); roomThree(time, bag)
    case "H" => help(); roomThree(time, bag)
    case "T" => printTime(time); roomThree(time, bag)
    case "Q" => System.exit(0)
    case "N" => roomFour(time + 1, newbag)
    case "W" => trap1()
    case "E" => roomOne(time + 1, newbag)
    case "S" =>
      println("Can't go that way champ")
    roomThree(time, newbag)
    case _ =>
      println("******ENTER A CORRECT DIRECTION******")
    roomThree(time, newbag)
  }
}

@tailrec def roomFour(time: Int, bag: Set[String]): Unit = {
  println("")
  if(time == 20) {
    println("#############################")
    println("YOU RAN OUT OF TIME!")
    println("#############################")
    System.exit(0)
    startGame()
  }
  if(time == 15) {
    println("")
    println("#############################")
    println("YOU ONLY HAVE 5 MORE MINUETES!")
    println("#############################")
    println("")
  }
  println("You are in the Dining room. What a wondeful place to feast. There is a door to the east and you can climb up to check the chandelier to the west. Though there seems to be something behind the fireplace...")
  println("You can go East, west, or you see a secret passage?")
  
  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(bag); roomFour(time, bag)
    case "Q" => System.exit(0)
    case "H" => help(); roomFour(time, bag)
    case "T" => printTime(time); roomFour(time, bag)
    case "N" => {
      println("You can't go that way brotha")
      roomFour(time, bag)
    }
    case "W" =>{
      if (bag.contains("The Sandwich of Doom")) {
        roomFive(time + 1, bag)
      }
      else {
        println("You need The Sandwich of Doom to go in here. Comeback when you've found it")
        roomFour(time, bag)
      }
    }
    case "E" => roomSix(time + 1, bag)
    case "S" => roomThree(time + 1, bag)
    case "SECRET" => {
      println("You find a secret passage to somewhere else in the house...")
      roomEleven(time + 1, bag)
    }
    case _ =>
      println("******ENTER A CORRECT DIRECTION******")
    roomFour(time + 1, bag)
  }
}

@tailrec def roomFive(time: Int, bag: Set[String]): Unit = {
  if(time == 20) {
    println("#############################")
    println("YOU RAN OUT OF TIME!")
    println("#############################")
    System.exit(0)
    startGame()
  }
  if(time == 15) {
    println("")
    println("#############################")
    println("YOU ONLY HAVE 5 MORE MINUETES!")
    println("#############################")
    println("")
  }
  println("")
  if (!(bag.contains("Macus Laptopus"))){
    println("")
    println("*******You found the Macus Laptopus!*********")
    println("")
  }
  val newbag = bag + "Macus Laptopus"
  println("")
  println("You are on top of the chandelier")
  println("You can only back the way you came...oh")
  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(newbag); roomFive(time, bag)
    case "H" => help(); roomOne(time, bag)
    case "Q" => System.exit(0)
    case "E" => roomFour(time + 1, newbag)
    case "T" => printTime(time); roomFive(time, bag)
    case "N" => println("You're staring at a wall")
    roomFive(time + 1, bag)
    case "W" => println("You're staring at a wall")
    roomFive(time + 1, bag)
    case "S" =>
      println("You're staring at a wall")
    roomFive(time + 1, bag)
    case _ =>
      println("******ENTER A CORRECT DIRECTION******")
    roomFive(time + 1, bag)
  }
}

@tailrec def roomSix(time: Int, bag: Set[String]): Unit = {
  if(time == 20) {
    println("#############################")
    println("YOU RAN OUT OF TIME!")
    println("#############################")
    System.exit(0)
    startGame()
  }
  if(time == 15) {
    println("")
    println("#############################")
    println("YOU ONLY HAVE 5 MORE MINUETES!")
    println("#############################")
    println("")
  }
  println("You are in the living room, you love to live in this room!")
  println("There are 3 doors in the room: East, West and North")
  println("Which door would you like to go through?")
  
  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(bag); roomSix(time, bag)
    case "H" => help(); roomSix(time, bag)
    case "Q" => System.exit(0)
    case "T" => printTime(time); roomSix(time, bag)
    case "N" => roomEleven(time + 1, bag)
    case "W" => roomFour(time + 1, bag)
    case "E" => roomEight(time + 1, bag)
    case "S" => roomOne(time + 1, bag)
    case _ =>
      println("******ENTER A CORRECT DIRECTION******")
    roomSix(time + 1, bag)
  }
}

@tailrec def roomSeven(time: Int, bag: Set[String]): Unit = {
  if(time == 20) {
    println("#############################")
    println("YOU RAN OUT OF TIME!")
    println("#############################")
    System.exit(0)
    startGame()
  }
  if(time == 15) {
    println("")
    println("#############################")
    println("YOU ONLY HAVE 5 MORE MINUETES!")
    println("#############################")
    println("")
  }
  val newbag = bag + "Part 3"
  println("")
  if (!(bag.contains("Part 3"))){
    println("*******YOU GOT PART 3*********")
  }
  println("")
  println("You are in the bathroom...a place of wonder")
  println("You can check the south window or go back through the north door")
  println("Which way would you like to go?")
  
  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(newbag); roomSeven(time, bag)
    case "H" => help(); roomSeven(time, bag)
    case "Q" => System.exit(0)
    case "N" => roomTwo(time + 1, newbag)
    case "S" => trap2()
    case "T" => printTime(time); roomSeven(time, bag)
    case "W" => println("You're staring at a wall")
    roomSeven(time + 1, bag)
    case "E" => println("You're staring at a wall")
    roomSeven(time + 1, bag)
    case _ =>
      println("******ENTER A CORRECT DIRECTION******")
    roomSeven(time + 1, bag)
  }
}

@tailrec def roomEight(time: Int, bag: Set[String]): Unit = {
  if(time == 20) {
    println("#############################")
    println("YOU RAN OUT OF TIME!")
    println("#############################")
    System.exit(0)
    startGame()
  }
  if(time == 15) {
    println("")
    println("#############################")
    println("YOU ONLY HAVE 5 MORE MINUETES!")
    println("#############################")
    println("")
  }
  println("You are in the guest room. Many people have used this room, but only some have returned...BUM, BUM, BUMMMMMMMMMM...")
  println("You see a door to the west and south, and to the north are stairs...")
  println("Which way would you like to go?")
  
  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(bag); roomEight(time, bag)
    case "Q" => System.exit(0)
    case "H" => help(); roomEight(time, bag)
    case "T" => printTime(time); roomEight(time, bag)
    case "N" => {
      if (bag.contains("Magical Car Keys")){
        println("Your attic is too unstable to go up there now!")
        roomEight(time, bag)
      } else {
        roomNine(time + 1, bag)
      }
    }
    case "W" => roomSix(time + 1, bag)
    case "E" => {
      println("You're staring at a wall")
      roomEight(time + 1, bag)
    }
    case "S" => roomTwo(time + 1, bag)
    case _ => {
      println("******ENTER A CORRECT DIRECTION******")
      roomEight(time + 1, bag)
    }
  }
}

@tailrec def roomNine(time: Int, bag: Set[String]): Unit = {
  if(time == 20) {
    println("#############################")
    println("YOU RAN OUT OF TIME!")
    println("#############################")
    System.exit(0)
    startGame()
  }
  if(time == 15) {
    println("")
    println("#############################")
    println("YOU ONLY HAVE 5 MORE MINUETES!")
    println("#############################")
    println("")
  }
  println("You have traveled to the the Attic...very spooky")
  println("You see a dark corridor to the east, and something smells funny to west")
  println("Where do you want to go?")
  
  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(bag); roomNine(time, bag)
    case "Q" => System.exit(0)
    case "H" => help(); roomNine(time, bag)
    case "N" => {
      println("You can't go that way brotha")
      roomNine(time + 1, bag)
    }
    case "E" => trap3()
    case "T" => printTime(time); roomNine(time, bag)
    case "W" => {
      if (bag.contains("Ultimate Plaid Shirt of Awesomeness")) {
        roomTen(time + 1, bag)
      } else {
        println("comeback with the Ultimate Plaid Shirt of Awesomeness to enter. You can only be awesome with plaid style to go this way...I know it's a strange house...")
        roomNine(time, bag)
      }
    }
    case "S" => roomEight(time + 1, bag)
    case _ => {
      println("******ENTER A CORRECT DIRECTION******")
      roomEleven(time + 1, bag)
    }
  }
}

def roomTen(time: Int, bag: Set[String]): Unit = {
  if(time == 20) {
    println("#############################")
    println("YOU RAN OUT OF TIME!")
    println("#############################")
    System.exit(0)
    startGame()
  }
  val newbag = bag + "Magical Car Keys"
  println("")
  
  if (time == 15) {
    println("#############################")
    println("YOU ONLY HAVE 5 MORE MINUETES!")
    println("#############################")
    println("")
  }
  
  if (!(bag.contains("Magical Car Keys"))){
    println("*******YOU GOT PART 4*********")
  }
  
  println("")
  println("You see a really scary dead rat on the floor...ew. Suddendly the light bulb breaks and you cannot see! ")
  println("Where do you go?")
  
  
  StdIn.readLine(">> ") match {
    case _ => {
      println("You feel the floor crumble beneath you and fall through!")
      roomOne(time+1, bag)
    }
  }
}
@tailrec def roomEleven(time: Int, bag: Set[String]): Unit = {
  if(time == 20) {
    println("#############################")
    println("YOU RAN OUT OF TIME!")
    println("#############################")
    System.exit(0)
    startGame()
  }
  if(time == 15) {
    println("")
    println("#############################")
    println("YOU ONLY HAVE 5 MORE MINUETES!")
    println("#############################")
    println("")
  }
  println("You are in the laundry room. Laundry is done in this room and not any other room. That's why its called the laundry room.")
  println("There is a door to the south, north and something behind the laundry detergent?")
  
  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(bag); roomEleven(time, bag)
    case "H" => help(); roomEleven(time, bag)
    case "T" => printTime(time); roomEleven(time, bag)
    case "Q" => System.exit(0)
    case "N" => {
      if (bag.contains("Magical Car Keys") && time < 20) {
        finalRoom(time + 1, bag)
      }
      else if (bag.contains("Magical Car Keys") && time > 20) {
        println("You ran out of time!")
        startGame()
      }
      else if (!(bag.contains("Magical Car Keys") && time < 20)){
        println("You don't have all the items! Check you're bag!")
        roomEleven(time, bag)
      }
      else if (!(bag.contains("Magical Car Keys") && time > 20)) {
        println("You are out of time and You don't have all the parts")
        println("")
        println("****************YOU LOSE!************************")
        println("")
        startGame()
      }
    }
    case "SECRET" => roomFour(time + 1, bag)
    case "E" => roomNine(time + 1, bag)
    case "S" => roomSix(time + 1, bag)
    case _ => {
      println("******ENTER A CORRECT DIRECTION******")
      roomEleven(time + 1, bag)
    }
  }
}

@tailrec def finalRoom(time: Int, bag: Set[String]): Unit = {
  println("-------------------------------------")
  println("You made it to the Garage!")
  println("")
  println("-------------------------------------")
  println("")
  println("There is a legion werewolves in the garage however, and they ask you a riddle. In order to get past them, you must answer correctly")
  println("RIDDLE: What gets wetter as it dries?")
  
  StdIn.readLine(">> ") match {
    case "B" => printBag(bag); finalRoom(time, bag)
    case "H" => help(); finalRoom(time, bag)
    case "T" => printTime(time); finalRoom(time, bag)
    case "Q" => println("Quit now?  You're almost there!"); finalRoom(time, bag)
    case "a towel" => println("YOU WIN")
    println("")
    case _ =>
      println("You didn't asnwer right. So they decide to eat you and take your stuff. Now we have stylish, mac enthusiastic werewolves that can drive and have the best sandwich in the world")
    println("***********YOU LOSE! **************")
    println("")
    startGame()
  }
}
