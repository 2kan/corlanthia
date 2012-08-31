Development is starting again after a long break
--

Corlanthia is an in-development text adventure game written in Java.

Corlanthia has some basic features implemented; so far users can move cardinally, inspect items, pickup items, see their inventory, drop one or many items, look in the room to see what objects are there. There is also a "debug" command that so far adds items to a room and displays all of the items in the room.

Update v0.2.1
--

+ Added title to the main window
+ Pressing the up arrow will put the player's last command into the command text field
+ Added Books class to handle the names, descriptions and contents of books
+ Added 'dance' command
* Changed license from Creative Commons Attribution 3.0 Unported to GPL
+ Made the panel on the left display the player's inventory
* Fixed inventory system not working properly
* Fixed GUI layout to be perfectly aligned on Windows (not OSX or Linux though)
* Fixed bug to do with exiting from menu
* Refactored entire book system
* Added more items to rooms
* Changed most variable name to start with lowercase letter
* Slightly refactored main command-interpretation method to use a series of "else if" selections rather than solely "if" selections
* Changed Inventory array to be of ints, rather than doubles
- Removed weapon and combat system (weapons still remain items though)


Next Actions
--

+ More rooms
+ Locked doors
+ Can read from letters
* Keys will have an actual purpose


License Info
--

Copyright (c) 2012 Tom Penney

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

See http://www.gnu.org/licenses/gpl-3.0.html for the full GNU General Public License.