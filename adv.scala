//Adventure Game
//Andrew Guistwite

import scala.annotation.tailrec
import scala.io.StdIn

def help(): Unit = {
  println("Press N to move forward, S to move back, W to move left, and E to move right")
  println("If you come across something secret, type in secret to see what happens")
  println("To quit, press Ctrl C or Q")
  println("You will not be able to enter certain rooms unless you have the correct parts to enter")
  startGame()
}

def printBag(bag: Set[String]): Unit = {
  println("Your bag contains: " + bag.mkString(","))
}

@tailrec def roomOne(time: Int, bag: Set[String]): Unit = {
  println("You are currently in Room 1.")
  println("There are 3 doors: North, West and East")
  println("Which door would you like to go through?")

  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(bag); roomOne(time, bag)
    case "Q" =>
    case "N" => roomSix(time + 1, bag)
    case "W" => roomThree(time + 1, bag)
    case "E" => roomTwo(time + 1, bag)
    case "S" =>
      println("You've entered, you cannot exit...")
      roomOne(time, bag)

    case _ =>
      println("******ENTER A CORRECT DIRECTION******")
      roomOne(time, bag)
  }
}
@tailrec def roomTwo(time: Int, bag: Set[String]): Unit = {
  println("You are currently in room two")
  println("there are two doors, north and south")
  println("which way would you like to go?")

  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(bag); roomTwo(time, bag)
    case "Q" =>
    case "N" => roomEight(time + 1, bag)
    case "W" => roomOne(time + 1, bag)
    case "E" =>
      println("You can't go that way champ")
      roomTwo(time+1, bag)
    case "S" =>
      if (bag.contains("Part 2")) {
        roomSeven(time + 1, bag)
      } else {
        println("Comeback with item 2 to enter")
      }
    case _ =>
      println("******ENTER A CORRECT DIRECTION******")
      roomOne(time, bag)
  }
}

@tailrec def roomThree(time: Int, bag: Set[String]): Unit = {
  val newbag = bag + "Part 1"
  println("You are currently in Room 3.")
  println("There are 2 doors inside: North and West")

  println("Which door would you like to go through?")
  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(newbag); roomThree(time, bag)
    case "Q" =>
    case "N" => roomFour(time + 1, newbag)
    case "W" => trap()
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
  println("You are in room four")
  println("You can go East, west, or you see a secret passage?")

  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(bag); roomFour(time, bag)
    case "Q" =>
    case "N" =>
      println("You can't go that way brotha")
      roomFour(time, bag)
    case "W" =>
      if (bag.contains("Part 1")) {
        roomFive(time + 1, bag)
      }
      else {
        println("You do not have the first piece yet to come into this room. Comeback when you have your first item")
        roomFour(time + 1, bag)
      }
    case "E" => roomSix(time + 1, bag)
    case "S" => roomThree(time + 1, bag)
    case "SECRET" => roomEleven(time + 1, bag)
    case _ =>
      println("******ENTER A CORRECT DIRECTION******")
      roomFour(time + 1, bag)
  }
}

@tailrec def roomFive(time: Int, bag: Set[String]): Unit = {
  val newbag = bag + "Part 2"
  println("You are currently in room 5")
  println("You can only back the way you came")
  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(newbag); roomFive(time, bag)
    case "Q" =>
    case "E" => roomFour(time + 1, newbag)
    case "N" =>
    case "W" =>
    case "S" =>
      println("You're staring at a wall")
      roomFive(time + 1, bag)
    case _ =>
      println("******ENTER A CORRECT DIRECTION******")
      roomFive(time + 1, bag)
  }
}

@tailrec def roomSix(time: Int, bag: Set[String]): Unit = {
  println("You are currently in Room 6.")
  println("There are 3 doors: East, West and North")
  println("Which door would you like to go through?")

  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(bag); roomSix(time, bag)
    case "Q" =>
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
  val newbag = bag + "Part 3"
  println("You are currently in room 7")
  println("You can either go South or back from whence you came")

  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(newbag); roomSeven(time, bag)
    case "Q" =>
    case "N" => roomTwo(time + 1, newbag)
    case "S" => trap()
    case "W" =>
    case "E" =>
      println("You're staring at a wall")
      roomSeven(time + 1, bag)
    case _ =>
      println("******ENTER A CORRECT DIRECTION******")
      roomSeven(time + 1, bag)
  }
}

@tailrec def roomEight(time: Int, bag: Set[String]): Unit = {
  println("You are in room eight")
  println("You can go N, S, or W")

  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(bag); roomEight(time, bag)
    case "Q" =>
    case "N" => roomNine(time + 1, bag)
    case "W" => roomSix(time + 1, bag)
    case "E" =>
      println("You're staring at a wall")
      roomEight(time + 1, bag)
    case "S" => roomTwo(time + 1, bag)
    case _ =>
      println("******ENTER A CORRECT DIRECTION******")
      roomEight(time + 1, bag)
  }
}

@tailrec def roomNine(time: Int, bag: Set[String]): Unit = {
  println("You are in room nine")
  println("you can go w, e, or s")

  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(bag); roomNine(time, bag)
    case "Q" =>
    case "N" =>
      println("You can't go that way brotha")
      roomNine(time + 1, bag)
    case "W" => roomEleven(time + 1, bag)
    case "E" =>
      if (bag.contains("Part 3")) {
        roomTen(time + 1, bag)
      } else {
        println("comeback with item 3 to enter")
      }
    case "S" => roomEight(time + 1, bag)
    case _ =>
      println("******ENTER A CORRECT DIRECTION******")
      roomEleven(time + 1, bag)
  }

}

@tailrec def roomTen(time: Int, bag: Set[String]): Unit = {
  val newbag = bag + "Part 4"
  println("You are in room 10 rn")
  println("You can only back the way you came")

  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(newbag); roomTen(time, bag)
    case "Q" =>
    case "W" => roomNine(time + 1, newbag)
    case "N" =>
    case "E" =>
    case "S" =>
      println("You're staring at a wall")
      roomTen(time + 1, bag)
    case _ =>
      println("******ENTER A CORRECT DIRECTION******")
      roomTen(time + 1, bag)
  }
}

@tailrec def roomEleven(time: Int, bag: Set[String]): Unit = {
  println("You are in room 11 rn.")
  println("You can go n,s,e,w")

  StdIn.readLine(">> ").toUpperCase match {
    case "B" => printBag(bag); roomEleven(time, bag)
    case "Q" =>
    case "N" =>
      if (bag.contains("Part 4")) {
        finalRoom(time + 1, bag)
      } else {
        println("come back with all parts to enter")
        roomEleven(time + 1, bag)
      }
    case "W" => roomFour(time + 1, bag)
    case "E" => roomNine(time + 1, bag)
    case "S" => roomSix(time + 1, bag)
    case "H" => help()
    case _ =>
      println("******ENTER A CORRECT DIRECTION******")
      roomEleven(time + 1, bag)
  }
}

@tailrec def finalRoom(time: Int, bag: Set[String]): Unit = {
  println("You are in the final room")
  println("good Luck")
  println("What gets wetter as it drys?")

  StdIn.readLine(">> ") match {
    case "B" => printBag(bag); finalRoom(time, bag)
    case "Q" => println("Quit now?  You're almost there!"); finalRoom(time, bag)
    case "towel" => println("YOU WIN")
    case _ =>
      println("You suck")
      finalRoom(time + 1, bag)
  }
}


def trap(): Unit = {
  println("You've died")
}

@tailrec def startGame(): Unit = {
  scala.io.StdIn.readLine(">> ").toUpperCase match {
    case "YES" => roomOne(1, Set())
    case "H" => help()
    case "Q" =>
    case _ =>
      println("When you are ready to begin please type \"yes\".")
      startGame()
  }
}

println("**************************************************")
println("**************************************************")

println("Start Your game?")
startGame()




  
  



  